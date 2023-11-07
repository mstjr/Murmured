package net.mstjr.murmured.api;

public interface MumbleProxyListener {

    default void onServerStarted(IMumbleServer server){}
    default void onServerStopped(IMumbleServer server){}

}
