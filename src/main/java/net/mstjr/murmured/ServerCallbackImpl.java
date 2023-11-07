package net.mstjr.murmured;

import com.zeroc.Ice.Current;
import net.mstjr.murmur.proxy.callback.ServerCallback;
import net.mstjr.murmur.proxy.server.channel.Channel;
import net.mstjr.murmur.proxy.server.entities.TextMessage;
import net.mstjr.murmur.proxy.server.users.User;

public class ServerCallbackImpl implements ServerCallback {

    private MumbleServer mumbleServer;
    public ServerCallbackImpl(MumbleServer mumbleServer) {
        this.mumbleServer = mumbleServer;
    }


    @Override
    public void userConnected(User state, Current current) {
        mumbleServer.getListeners().forEach((k,v)-> {
            v.onUserConnected(mumbleServer.getOnlineUser(state), mumbleServer);
        });
    }

    @Override
    public void userDisconnected(User state, Current current) {
        mumbleServer.getListeners().forEach((k,v)-> {
            v.onUserDisconnected(mumbleServer.getOnlineUser(state), mumbleServer);
        });
    }

    @Override
    public void userStateChanged(User state, Current current) {
        mumbleServer.getListeners().forEach((k,v)-> {
            v.onUserStateChanged(mumbleServer.getOnlineUser(state), mumbleServer);
        });
    }

    @Override
    public void userTextMessage(User state, TextMessage message, Current current) {
        mumbleServer.getListeners().forEach((k,v)-> {
            v.onUserTextMessage(mumbleServer.getOnlineUser(state), message.text, mumbleServer);
        });
    }

    @Override
    public void channelCreated(Channel state, Current current) {
        mumbleServer.getListeners().forEach((k,v)-> {
            v.onChannelCreated(mumbleServer.getChannel(state), mumbleServer);
        });
    }

    @Override
    public void channelRemoved(Channel state, Current current) {
        mumbleServer.getListeners().forEach((k,v)-> {
            v.onChannelRemoved(mumbleServer.getChannel(state), mumbleServer);
        });
    }

    @Override
    public void channelStateChanged(Channel state, Current current) {
        mumbleServer.getListeners().forEach((k,v)-> {
            v.onChannelStateChanged(mumbleServer.getChannel(state), mumbleServer);
        });
    }
}
