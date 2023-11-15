package net.mstjr.murmured;

import com.zeroc.Ice.*;
import net.mstjr.murmur.exceptions.invalid.InvalidCallbackException;
import net.mstjr.murmur.exceptions.invalid.InvalidSecretException;
import net.mstjr.murmur.prx.*;
import net.mstjr.murmured.api.*;

import java.io.IOException;
import java.lang.Exception;
import java.util.HashMap;
import java.util.Map;

public class MumbleProxy implements IMumbleProxy {

    private Map<Integer, IMumbleServer> servers = new HashMap<>();


    private IceClient client;
    private MetaPrx meta;
    private ObjectAdapter adapter;
    private String version;

    private String address, secret, callbackAddress;
    private int port, callbackPort, timeout;

    private boolean isNewAllServers = true;

    private Map<String, String> _defaultConf = null;

    private MetaCallbackPrx metaCallbackPrx;

    private Map<Integer, MumbleProxyListener> listeners = new HashMap<>();


    /**
     * Connect to Murmur server
     *
     * @param address         Murmur server address
     * @param port            Murmur server port
     * @param secret          Murmur server secret
     * @param callbackAddress Callback address
     * @param callbackPort    Callback port
     * @param timeout         Timeout
     * @throws ConnectionRefusedException If connection refused
     * @throws InvalidSecretException     If secret is invalid
     */
    @Override
    public void connect(String address, int port, String secret, String callbackAddress, int callbackPort, int timeout) throws ConnectionRefusedException, InvalidSecretException {
        if (isConnected())
            throw new RuntimeException("Already connected");

        this.closed = false;
        this.address = address;
        this.port = port;
        this.callbackAddress = callbackAddress;
        this.callbackPort = callbackPort;
        this.client = new IceClient();
        this.client.connect(address, port, secret, callbackAddress, callbackPort, timeout);
        this.meta = this.client.getMeta();
        this.adapter = this.client.getAdapter();
    }

    /**
     * Get all servers
     *
     * @return Map of servers
     */
    @Override
    public Map<Integer, IMumbleServer> getAllServers() {
        if (isNewAllServers) {
            isNewAllServers = false;

            try {
                for (ServerPrx allServer : meta.getAllServers()) {
                    IMumbleServer vs = new MumbleServer(allServer, this);
                    if (!servers.containsKey(vs.getId()))
                        servers.put(vs.getId(), vs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return servers;
    }

    /**
     * Get server by id
     *
     * @param id Server id
     * @return Server
     */
    @Override
    public MumbleServer getServer(int id) {
        if (!servers.containsKey(id)) {
            ServerPrx server = null;
            try {
                server = meta.getServer(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (server == null)
                throw new RuntimeException("Server not found");

            MumbleServer vs = new MumbleServer(server, this);

            // add to cache
            if (!servers.containsKey(id))
                servers.put(id, vs);
            else
                servers.replace(id, vs);
        }

        return (MumbleServer) servers.get(id);
    }

    /**
     * Create new server
     *
     * @param slots Server slots
     * @param port  Server port
     * @return Server
     */
    @Override
    public MumbleServer createServer(int slots, int port) {
        ServerPrx server = null;

        try {
            server = meta.newServer();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (server == null)
            throw new RuntimeException("Server not created");

        MumbleServer vs = new MumbleServer(server, this);

        // setup server
        vs.setPort((port == 0) ? getNextAvailableServerPort() : port);
        vs.setSlots(slots);

        // add to cache
        servers.put(vs.getId(), vs);

        return vs;
    }

    /**
     * Delete server
     *
     * @param id Server id
     */
    @Override
    public void deleteServer(int id) {

        try {
            ServerPrx server = meta.getServer(id);
            server.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
        servers.remove(id);
    }

    /**
     * Get version string
     *
     * @return Version string
     */
    public String getVersionString() {
        if (version == null) {
            version = String.format("%d.%d.%d", meta.getVersion().major, meta.getVersion().minor, meta.getVersion().patch);
        }
        return version;
    }

    /**
     * Return true if connected
     *
     * @return True if connected
     */
    @Override
    public boolean isConnected() {
        try {
            meta.ice_ping();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get default configuration
     *
     * @return Default configuration
     */
    @Override
    public Map<String, String> getDefaultConf() {
        if (_defaultConf != null)
            return _defaultConf;

        _defaultConf = new HashMap<>();
        try {
            _defaultConf.putAll(meta.getDefaultConf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return _defaultConf;
    }

    /**
     * Get next available server port
     *
     * @return Next available server port
     */
    @Override
    public int getNextAvailableServerPort() {
        int defaultPort = Integer.parseInt(getDefaultConf().get("port"));
        int lastId = 0;
        for (Map.Entry<Integer, IMumbleServer> entry : getAllServers().entrySet()) {
            lastId = entry.getKey();
        }

        int port = 0;
        while (true) {
            int newPort = (defaultPort + lastId);

            if (newPort > ((Short.MAX_VALUE) * 2))
                newPort = ((Short.MAX_VALUE) * 2) - (newPort - defaultPort);

            if (!Utils.isPortAvailable(address, newPort)) {
                port = newPort;
                break;
            }
            lastId++;
        }

        return port;
    }

    /**
     * Get host
     *
     * @return Host
     */
    @Override
    public String getHost() {
        return address;
    }

    /**
     * Get port
     *
     * @return Port
     */
    @Override
    public int getPort() {
        return port;
    }

    @Override
    public int registerListener(MumbleProxyListener listener) {
        if (metaCallbackPrx == null) {
            if (!this.closed)
                metaCallbackPrx = MetaCallbackPrx.uncheckedCast(adapter.addWithUUID(new MetaCallbackImpl(this)));
            try {
                getMeta().addCallback(metaCallbackPrx);
            } catch (InvalidCallbackException | InvalidSecretException e) {
                throw new RuntimeException(e);
            }
        }

        int id = listeners.isEmpty() ? 0 : ((int) Utils.getLastElement(listeners.keySet())) + 1;
        listeners.put(id, listener);
        return 0;
    }

    @Override
    public void unregisterListener(int id) {
        listeners.remove(id);

        if (listeners.isEmpty()) {
            try {
                meta.removeCallback(metaCallbackPrx);
            } catch (InvalidCallbackException | InvalidSecretException e) {
                e.printStackTrace();
            }
            metaCallbackPrx = null;
        }
    }

    @Override
    public void unregisterListener(MumbleProxyListener listener) {
        listeners.entrySet().removeIf(entry -> entry.getValue().equals(listener));

        if (listeners.isEmpty()) {
            try {
                meta.removeCallback(metaCallbackPrx);
            } catch (InvalidCallbackException | InvalidSecretException e) {
                e.printStackTrace();
            }
            metaCallbackPrx = null;
        }
    }

    public Map<Integer, MumbleProxyListener> getListeners() {
        return listeners;
    }

    /**
     * Get meta
     *
     * @return Meta
     */
    @Override
    public MetaPrx getMeta() {
        return meta;
    }

    /**
     * Get client
     *
     * @return Client
     */
    public IceClient getClient() {
        return client;
    }

    /**
     * Get adapter
     *
     * @return Adapter
     */
    public ObjectAdapter getAdapter() {
        return adapter;
    }

    /**
     * Get version
     *
     * @return Version
     */
    @Override
    public String getVersion() {
        return getVersionString();
    }


    public Communicator getCommunicator() {
        return client.getIc();
    }

    private boolean closed = false;

    /**
     * Close connection
     */
    @Override
    public void close() {
        if (!closed) {
            this.servers.forEach((id, server) -> {
                try {
                    server.close();
                    System.out.println("Closed server " + id);
                } catch (IOException e) {
                    System.out.println("Failed to close server " + id);
                }
            });

            if (metaCallbackPrx != null) {
                try {
                    meta.removeCallback(metaCallbackPrx);
                } catch (InvalidCallbackException e) {
                    throw new RuntimeException(e);
                } catch (InvalidSecretException e) {
                    throw new RuntimeException(e);
                }
            }

            this.servers.forEach((id, server) -> {
                server.stop();
                System.out.println("Closed server " + id);
            });

            for (int i : this.servers.keySet()) {
                deleteServer(i);
            }

            listeners.clear();
            closed = true;
            this.client.close();
        }
    }

    /**
     * Set debug (Debug mode will print all messages if true)
     *
     * @param debug Debug
     */
    public void setDebug(boolean debug) {
        client.setDebug(debug);
    }
}
