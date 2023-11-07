package net.mstjr.murmured.api;

public interface MumbleServerListener {
    default void onChannelCreated(VirtualServerEntity.Channel channel, IMumbleServer server){}
    default void onChannelRemoved(VirtualServerEntity.Channel channel, IMumbleServer server){}
    default void onChannelStateChanged(VirtualServerEntity.Channel channel, IMumbleServer server){}
    default void onUserConnected(VirtualServerEntity.OnlineUser user, IMumbleServer server){}
    default void onUserDisconnected(VirtualServerEntity.OnlineUser user, IMumbleServer server){}
    default void onUserStateChanged(VirtualServerEntity.OnlineUser user, IMumbleServer server){}
    default void onUserTextMessage(VirtualServerEntity.OnlineUser user, String message, IMumbleServer server){}

    default void onContextAction(String action, VirtualServerEntity.OnlineUser user, int session, int channelId, IMumbleServer server){}

}
