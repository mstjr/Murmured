package net.mstjr.murmured.api;

import com.zeroc.Ice.Object;

public interface IInstanceCallbackHandler extends Object {
    void started(IMumbleServer server);
    void stopped(IMumbleServer server);
}
