package net.mstjr.murmured.api;

import com.zeroc.Ice.ConnectionRefusedException;
import net.mstjr.murmur.exceptions.invalid.InvalidSecretException;
import net.mstjr.murmur.prx.MetaPrx;
import net.mstjr.murmured.MumbleServer;

import java.io.Closeable;
import java.util.Map;

public interface IMumbleProxy extends Closeable {

    void connect(String address, int port, String secret, String callbackAddress, int callbackPort, int timeout) throws ConnectionRefusedException, InvalidSecretException;
    default void connect(String address, int port, String secret, String callbackAddress, int callbackPort) throws ConnectionRefusedException, InvalidSecretException{
        connect(address, port, secret, callbackAddress, callbackPort, 10000);
    }
    default void connect(String address, int port, String secret) throws ConnectionRefusedException, InvalidSecretException{
        connect(address, port, secret, "127.0.0.1", 0);
    }


    Map<Integer, IMumbleServer> getAllServers();
    MumbleServer getServer(int id);
    MumbleServer createServer(int slots, int port);
    default MumbleServer createServer(int slots){
        return createServer(slots, 10);
    }
    default MumbleServer createServer(){
        return createServer(10);
    }

    void deleteServer(int id);
    boolean isConnected();

    Map<String, String> getDefaultConf();

    int getNextAvailableServerPort();
    String getHost();
    int getPort();

    MetaPrx getMeta();
    String getVersion();
}
