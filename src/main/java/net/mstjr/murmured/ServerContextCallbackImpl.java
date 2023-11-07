package net.mstjr.murmured;

import com.zeroc.Ice.Current;
import com.zeroc.Ice.Object;
import net.mstjr.murmur.proxy.callback.ServerContextCallback;
import net.mstjr.murmur.proxy.server.users.User;

public class ServerContextCallbackImpl implements ServerContextCallback {
    private MumbleServer mumbleServer;
    public ServerContextCallbackImpl(MumbleServer mumbleServer) {
        this.mumbleServer = mumbleServer;
    }

    @Override
    public void contextAction(String action, User usr, int session, int channelid, Current current) {
        mumbleServer.getListeners().forEach((k,v)-> {
            v.onContextAction(action, mumbleServer.getOnlineUser(usr), session, channelid, mumbleServer);
        });
    }
}
