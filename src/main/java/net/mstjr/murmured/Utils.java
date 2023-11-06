package net.mstjr.murmured;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Utils {
    /**
     * Check if a port is available
     * @param address The address to check
     * @param port The port to check
     * @return true if the port is available, false otherwise
     */
    public static boolean isPortAvailable(String address, int port) {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReuseAddress(false);
            serverSocket.bind(new InetSocketAddress(InetAddress.getByName(address), port), 1);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
