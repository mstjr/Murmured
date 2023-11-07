package net.mstjr.murmured;

import com.zeroc.Ice.Current;
import net.mstjr.murmur.exceptions.invalid.InvalidSecretException;
import net.mstjr.murmur.proxy.callback.MetaCallback;
import net.mstjr.murmur.prx.ServerPrx;

public class MetaCallbackImpl implements MetaCallback {
    private MumbleProxy server;
    public MetaCallbackImpl(MumbleProxy server) {
        this.server = server;
    }

    @Override
    public void started(ServerPrx srv, Current current) {
        server.getListeners().values().forEach(listener -> {
            try {
                listener.onServerStarted(server.getServer(srv.id()));
            } catch (InvalidSecretException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void stopped(ServerPrx srv, Current current) {
        server.getListeners().values().forEach(listener -> {
            try {
                listener.onServerStopped(server.getServer(srv.id()));
            } catch (InvalidSecretException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
