package net.mstjr.murmured.api;

import com.zeroc.Ice.Object;

public interface IVirtualServerContextCallbackHandler extends Object{
    void contextAction(String action, VirtualServerEntity.OnlineUser user, int session, int channelId, IMumbleServer server);
}
