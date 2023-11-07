package net.mstjr.murmured.api;

import com.zeroc.Ice.ConnectionRefusedException;
import net.mstjr.murmur.exceptions.invalid.InvalidSecretException;
import net.mstjr.murmur.prx.MetaPrx;
import net.mstjr.murmured.MumbleProxy;
import net.mstjr.murmured.MumbleServer;

import java.io.Closeable;
import java.util.Map;

public interface IMumbleProxy extends Closeable {

    /**
     * Connects to a murmur server.
     * @param address The address of the server.
     * @param port The port of the server.
     * @param secret The secret of the server.
     * @param callbackAddress The address of the callback server.
     * @param callbackPort The port of the callback server.
     * @param timeout The timeout of the connection.
     * @throws ConnectionRefusedException If the connection is refused.
     * @throws InvalidSecretException If the secret is invalid.
     */
    void connect(String address, int port, String secret, String callbackAddress, int callbackPort, int timeout) throws ConnectionRefusedException, InvalidSecretException;

    /**
     * Connects to a murmur server.
     * @param address The address of the server.
     * @param port The port of the server.
     * @param secret The secret of the server.
     * @param callbackAddress The address of the callback server.
     * @param callbackPort The port of the callback server.
     * @throws ConnectionRefusedException If the connection is refused.
     * @throws InvalidSecretException If the secret is invalid.
     */
    default void connect(String address, int port, String secret, String callbackAddress, int callbackPort) throws ConnectionRefusedException, InvalidSecretException{
        connect(address, port, secret, callbackAddress, callbackPort, 10000);
    }

    /**
     * Connects to a murmur server.
     * @param address The address of the server.
     * @param port The port of the server.
     * @param secret The secret of the server.
     * @throws ConnectionRefusedException If the connection is refused.
     * @throws InvalidSecretException If the secret is invalid.
     */
    default void connect(String address, int port, String secret) throws ConnectionRefusedException, InvalidSecretException{
        connect(address, port, secret, "127.0.0.1", 0);
    }

    /**
     * Connects to a murmur server.
     * @return The connected server.
     */
    Map<Integer, IMumbleServer> getAllServers();

    /**
     * Gets a murmur server.
     * @param id The id of the server.
     * @return The server.
     */
    MumbleServer getServer(int id);

    /**
     * Creates a murmur server.
     * @param slots The slots of the server.
     * @param port The port of the server.
     * @return The created server.
     */
    MumbleServer createServer(int slots, int port);

    /**
     * Creates a murmur server.
     * @param slots The slots of the server.
     * @return The created server.
     */
    default MumbleServer createServer(int slots){
        return createServer(slots, 10);
    }

    /**
     * Creates a murmur server.
     * @return The created server.
     */
    default MumbleServer createServer(){
        return createServer(10);
    }

    /**
     * Deletes a murmur server.
     * @param id The id of the server.
     */
    void deleteServer(int id);

    /**
     * Checks if the proxy is connected.
     * @return True if the proxy is connected.
     */
    boolean isConnected();

    /**
     * Gets the default configuration of the proxy.
     * @return The default configuration.
     */
    Map<String, String> getDefaultConf();

    /**
     * Gets the next available server port.
     * @return The next available server port.
     * FIXME: Give the same port every time.
     * @deprecated Do not use.
     */
    int getNextAvailableServerPort();

    /**
     * Get the hostname of the proxy.
     * @return The hostname of the proxy.
     */
    String getHost();

    /**
     * Get the port of the proxy.
     * @return The port of the proxy.
     */
    int getPort();

    int registerListener(MumbleProxyListener listener);
    void unregisterListener(int id);
    void unregisterListener(MumbleProxyListener listener);

    /**
     * Get the meta proxy.
     * @return The meta proxy.
     * @implNote If you don't know what this is, you probably don't need it.
     */
    MetaPrx getMeta();

    /**
     * Get the version of the proxy. (Murmur)
     * @return The version of the proxy.
     */
    String getVersion();
}
