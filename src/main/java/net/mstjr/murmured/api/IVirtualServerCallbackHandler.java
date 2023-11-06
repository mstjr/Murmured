package net.mstjr.murmured.api;

import com.zeroc.Ice.Object;

public interface IVirtualServerCallbackHandler extends Object {
    void channelCreated(VirtualServerEntity.Channel channel, IMumbleServer server);
    void channelRemoved(VirtualServerEntity.Channel channel, IMumbleServer server);
    void channelStateChanged(VirtualServerEntity.Channel channel, IMumbleServer server);
    void userConnected(VirtualServerEntity.OnlineUser user, IMumbleServer server);
    void userDisconnected(VirtualServerEntity.OnlineUser user, IMumbleServer server);
    void userStateChanged(VirtualServerEntity.OnlineUser user, IMumbleServer server);
    void userTextMessage(VirtualServerEntity.OnlineUser user, String message, IMumbleServer server);
}
