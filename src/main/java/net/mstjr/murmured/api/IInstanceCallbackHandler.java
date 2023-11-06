package net.mstjr.murmured.api;

import com.zeroc.Ice.Object;

/**
 * @implNote This interface is not working yet.
 */
public interface IInstanceCallbackHandler extends Object {
    void started(IMumbleServer server);
    void stopped(IMumbleServer server);
}
