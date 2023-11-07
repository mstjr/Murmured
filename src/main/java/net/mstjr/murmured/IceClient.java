package net.mstjr.murmured;

import com.zeroc.Ice.*;
import net.mstjr.murmur.exceptions.invalid.InvalidSecretException;
import net.mstjr.murmur.prx.MetaPrx;

import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IceClient extends Application {

    private static final Logger LOGGER = Logger.getLogger("Murmured");

    private InitializationData data;
    private Communicator ic;
    private int timeout;

    private MetaPrx meta;
    private ObjectAdapter adapter;
    private boolean debug = false;

    public MetaPrx connect(String address, int port, String secret, String callbackAddress, int callbackPort, int timeout) throws ConnectionRefusedException, InvalidSecretException {
        if (debug) LOGGER.info("Preparing to connect to " + address + ":" + port + " with secret " + secret);
        this.timeout = timeout;

        run(new String[0]);

        ic = Util.initialize(data);

        if (secret != null && !secret.isEmpty()) {
            ic.getImplicitContext().put("secret", secret);
        }

        try {
            String connectionString = "Meta:tcp -h " + address + " -p " + port + " -t " + timeout;

            ObjectPrx metaObjectPrx = ic.stringToProxy(connectionString);
            metaObjectPrx.ice_ping();

            meta = MetaPrx.uncheckedCast(metaObjectPrx);

            String portString = (callbackPort > 0) ? " -p " + callbackPort : "";
            String callbackConnectionString = "tcp -h " + callbackAddress + portString + " -t " + timeout;

            ic.getProperties().setProperty("Ice.PrintAdapterReady", "0");
            adapter = ic.createObjectAdapterWithEndpoints("Callback.Client", callbackConnectionString);
            adapter.activate();

            meta.ice_ping();
        } catch (Exception e) {
            if (debug) LOGGER.log(Level.SEVERE, "Error connecting to server: " + e.getMessage());
            throw new ConnectionRefusedException();
        }

        try {
            meta.getAllServers()[0].setConf("allowhtml", "true");
        } catch (InvalidSecretException e) {
            if (debug) LOGGER.log(Level.SEVERE, "Invalid secret: " + e.getMessage());
            throw new InvalidSecretException();
        }

        if (debug) LOGGER.info("Successfully connected to " + address + ":" + port + " with secret " + secret);
        return meta;
    }

    public MetaPrx connect(String address, int port, String secret, String callbackAddress, int callbackPort) throws InvalidSecretException {
        return connect(address, port, secret, callbackAddress, callbackPort, 10000);
    }

    public MetaPrx connect(String address, int port, String secret) throws InvalidSecretException {
        return connect(address, port, secret, "127.0.0.1", 0);
    }

    public MetaPrx getMeta() {
        return meta;
    }

    public ObjectAdapter getAdapter() {
        return adapter;
    }

    @Override
    public int run(String[] args) {
        shutdownOnInterrupt();

        data = new InitializationData();
        data.properties = Util.createProperties();
        data.properties.setProperty("Ice.ImplicitContext", "Shared");
        data.properties.setProperty("Ice.MessageSizeMax", "65535");
        return 0;
    }

    public Communicator getIc() {
        return ic;
    }

    public void close() {
        System.out.println("Closing connection");
        ic.destroy();
        if(debug) LOGGER.info("Connection closed");
    }

    public void setDebug(boolean b) {
        this.debug = b;
    }
}
