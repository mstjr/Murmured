//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `Murmur.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package net.mstjr.murmur.prx;

import net.mstjr.murmur.proxy.server.channel.Channel;
import net.mstjr.murmur.proxy.server.Server;
import net.mstjr.murmur.proxy.server.entities.TextMessage;
import net.mstjr.murmur.proxy.server.users.User;
import net.mstjr.murmur.prxl._ServerCallbackPrxI;
import net.mstjr.murmur.proxy.callback.MetaCallback;

/**
 * Callback interface for servers. You can supply an implementation of this to receive notification
 * messages from the server.
 * If an added callback ever throws an exception or goes away, it will be automatically removed.
 * Please note that all callbacks are done asynchronously; murmur does not wait for the callback to
 * complete before continuing processing.
 * Note that callbacks are removed when a server is stopped, so you should have a callback for
 * {@link MetaCallback.started} which calls {@link Server.addCallback}.
 *
 * @see MetaCallback
 * @see Server.addCallback
 **/
public interface ServerCallbackPrx extends com.zeroc.Ice.ObjectPrx {
    /**
     * Called when a user connects to the server.
     *
     * @param state State of connected user.
     **/
    default void userConnected(User state) {
        userConnected(state, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Called when a user connects to the server.
     *
     * @param state   State of connected user.
     * @param context The Context map to send with the invocation.
     **/
    default void userConnected(User state, java.util.Map<String, String> context) {
        _iceI_userConnectedAsync(state, context, true).waitForResponse();
    }

    /**
     * Called when a user connects to the server.
     *
     * @param state State of connected user.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> userConnectedAsync(User state) {
        return _iceI_userConnectedAsync(state, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Called when a user connects to the server.
     *
     * @param state   State of connected user.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> userConnectedAsync(User state, java.util.Map<String, String> context) {
        return _iceI_userConnectedAsync(state, context, false);
    }

    /**
     * @param iceP_state -
     * @param context    -
     * @param sync       -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_userConnectedAsync(User iceP_state, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "userConnected", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, ostr -> {
            User.ice_write(ostr, iceP_state);
        }, null);
        return f;
    }

    /**
     * Called when a user disconnects from the server. The user has already been removed, so you can no longer use methods like {@link Server.getState}
     * to retrieve the user's state.
     *
     * @param state State of disconnected user.
     **/
    default void userDisconnected(User state) {
        userDisconnected(state, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Called when a user disconnects from the server. The user has already been removed, so you can no longer use methods like {@link Server.getState}
     * to retrieve the user's state.
     *
     * @param state   State of disconnected user.
     * @param context The Context map to send with the invocation.
     **/
    default void userDisconnected(User state, java.util.Map<String, String> context) {
        _iceI_userDisconnectedAsync(state, context, true).waitForResponse();
    }

    /**
     * Called when a user disconnects from the server. The user has already been removed, so you can no longer use methods like {@link Server.getState}
     * to retrieve the user's state.
     *
     * @param state State of disconnected user.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> userDisconnectedAsync(User state) {
        return _iceI_userDisconnectedAsync(state, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Called when a user disconnects from the server. The user has already been removed, so you can no longer use methods like {@link Server.getState}
     * to retrieve the user's state.
     *
     * @param state   State of disconnected user.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> userDisconnectedAsync(User state, java.util.Map<String, String> context) {
        return _iceI_userDisconnectedAsync(state, context, false);
    }

    /**
     * @param iceP_state -
     * @param context    -
     * @param sync       -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_userDisconnectedAsync(User iceP_state, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "userDisconnected", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, ostr -> {
            User.ice_write(ostr, iceP_state);
        }, null);
        return f;
    }

    /**
     * Called when a user state changes. This is called if the user moves, is renamed, is muted, deafened etc.
     *
     * @param state New state of user.
     **/
    default void userStateChanged(User state) {
        userStateChanged(state, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Called when a user state changes. This is called if the user moves, is renamed, is muted, deafened etc.
     *
     * @param state   New state of user.
     * @param context The Context map to send with the invocation.
     **/
    default void userStateChanged(User state, java.util.Map<String, String> context) {
        _iceI_userStateChangedAsync(state, context, true).waitForResponse();
    }

    /**
     * Called when a user state changes. This is called if the user moves, is renamed, is muted, deafened etc.
     *
     * @param state New state of user.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> userStateChangedAsync(User state) {
        return _iceI_userStateChangedAsync(state, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Called when a user state changes. This is called if the user moves, is renamed, is muted, deafened etc.
     *
     * @param state   New state of user.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> userStateChangedAsync(User state, java.util.Map<String, String> context) {
        return _iceI_userStateChangedAsync(state, context, false);
    }

    /**
     * @param iceP_state -
     * @param context    -
     * @param sync       -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_userStateChangedAsync(User iceP_state, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "userStateChanged", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, ostr -> {
            User.ice_write(ostr, iceP_state);
        }, null);
        return f;
    }

    /**
     * Called when user writes a text message
     *
     * @param state   the User sending the message
     * @param message the TextMessage the user has sent
     **/
    default void userTextMessage(User state, TextMessage message) {
        userTextMessage(state, message, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Called when user writes a text message
     *
     * @param state   the User sending the message
     * @param message the TextMessage the user has sent
     * @param context The Context map to send with the invocation.
     **/
    default void userTextMessage(User state, TextMessage message, java.util.Map<String, String> context) {
        _iceI_userTextMessageAsync(state, message, context, true).waitForResponse();
    }

    /**
     * Called when user writes a text message
     *
     * @param state   the User sending the message
     * @param message the TextMessage the user has sent
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> userTextMessageAsync(User state, TextMessage message) {
        return _iceI_userTextMessageAsync(state, message, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Called when user writes a text message
     *
     * @param state   the User sending the message
     * @param message the TextMessage the user has sent
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> userTextMessageAsync(User state, TextMessage message, java.util.Map<String, String> context) {
        return _iceI_userTextMessageAsync(state, message, context, false);
    }

    /**
     * @param iceP_state   -
     * @param iceP_message -
     * @param context      -
     * @param sync         -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_userTextMessageAsync(User iceP_state, TextMessage iceP_message, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "userTextMessage", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, ostr -> {
            User.ice_write(ostr, iceP_state);
            TextMessage.ice_write(ostr, iceP_message);
        }, null);
        return f;
    }

    /**
     * Called when a new channel is created.
     *
     * @param state State of new channel.
     **/
    default void channelCreated(Channel state) {
        channelCreated(state, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Called when a new channel is created.
     *
     * @param state   State of new channel.
     * @param context The Context map to send with the invocation.
     **/
    default void channelCreated(Channel state, java.util.Map<String, String> context) {
        _iceI_channelCreatedAsync(state, context, true).waitForResponse();
    }

    /**
     * Called when a new channel is created.
     *
     * @param state State of new channel.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> channelCreatedAsync(Channel state) {
        return _iceI_channelCreatedAsync(state, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Called when a new channel is created.
     *
     * @param state   State of new channel.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> channelCreatedAsync(Channel state, java.util.Map<String, String> context) {
        return _iceI_channelCreatedAsync(state, context, false);
    }

    /**
     * @param iceP_state -
     * @param context    -
     * @param sync       -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_channelCreatedAsync(Channel iceP_state, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "channelCreated", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, ostr -> {
            Channel.ice_write(ostr, iceP_state);
        }, null);
        return f;
    }

    /**
     * Called when a channel is removed. The channel has already been removed, you can no longer use methods like {@link Server.getChannelState}
     *
     * @param state State of removed channel.
     **/
    default void channelRemoved(Channel state) {
        channelRemoved(state, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Called when a channel is removed. The channel has already been removed, you can no longer use methods like {@link Server.getChannelState}
     *
     * @param state   State of removed channel.
     * @param context The Context map to send with the invocation.
     **/
    default void channelRemoved(Channel state, java.util.Map<String, String> context) {
        _iceI_channelRemovedAsync(state, context, true).waitForResponse();
    }

    /**
     * Called when a channel is removed. The channel has already been removed, you can no longer use methods like {@link Server.getChannelState}
     *
     * @param state State of removed channel.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> channelRemovedAsync(Channel state) {
        return _iceI_channelRemovedAsync(state, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Called when a channel is removed. The channel has already been removed, you can no longer use methods like {@link Server.getChannelState}
     *
     * @param state   State of removed channel.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> channelRemovedAsync(Channel state, java.util.Map<String, String> context) {
        return _iceI_channelRemovedAsync(state, context, false);
    }

    /**
     * @param iceP_state -
     * @param context    -
     * @param sync       -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_channelRemovedAsync(Channel iceP_state, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "channelRemoved", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, ostr -> {
            Channel.ice_write(ostr, iceP_state);
        }, null);
        return f;
    }

    /**
     * Called when a new channel state changes. This is called if the channel is moved, renamed or if new links are added.
     *
     * @param state New state of channel.
     **/
    default void channelStateChanged(Channel state) {
        channelStateChanged(state, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Called when a new channel state changes. This is called if the channel is moved, renamed or if new links are added.
     *
     * @param state   New state of channel.
     * @param context The Context map to send with the invocation.
     **/
    default void channelStateChanged(Channel state, java.util.Map<String, String> context) {
        _iceI_channelStateChangedAsync(state, context, true).waitForResponse();
    }

    /**
     * Called when a new channel state changes. This is called if the channel is moved, renamed or if new links are added.
     *
     * @param state New state of channel.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> channelStateChangedAsync(Channel state) {
        return _iceI_channelStateChangedAsync(state, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Called when a new channel state changes. This is called if the channel is moved, renamed or if new links are added.
     *
     * @param state   New state of channel.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> channelStateChangedAsync(Channel state, java.util.Map<String, String> context) {
        return _iceI_channelStateChangedAsync(state, context, false);
    }

    /**
     * @param iceP_state -
     * @param context    -
     * @param sync       -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_channelStateChangedAsync(Channel iceP_state, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "channelStateChanged", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, ostr -> {
            Channel.ice_write(ostr, iceP_state);
        }, null);
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     *
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ServerCallbackPrx checkedCast(com.zeroc.Ice.ObjectPrx obj) {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), ServerCallbackPrx.class, _ServerCallbackPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     *
     * @param obj     The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ServerCallbackPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context) {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), ServerCallbackPrx.class, _ServerCallbackPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     *
     * @param obj   The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ServerCallbackPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet) {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), ServerCallbackPrx.class, _ServerCallbackPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     *
     * @param obj     The untyped proxy.
     * @param facet   The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ServerCallbackPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context) {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), ServerCallbackPrx.class, _ServerCallbackPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     *
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static ServerCallbackPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj) {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, ServerCallbackPrx.class, _ServerCallbackPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     *
     * @param obj   The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static ServerCallbackPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet) {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, ServerCallbackPrx.class, _ServerCallbackPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     *
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default ServerCallbackPrx ice_context(java.util.Map<String, String> newContext) {
        return (ServerCallbackPrx) _ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     *
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default ServerCallbackPrx ice_adapterId(String newAdapterId) {
        return (ServerCallbackPrx) _ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     *
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default ServerCallbackPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints) {
        return (ServerCallbackPrx) _ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     *
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default ServerCallbackPrx ice_locatorCacheTimeout(int newTimeout) {
        return (ServerCallbackPrx) _ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     *
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default ServerCallbackPrx ice_invocationTimeout(int newTimeout) {
        return (ServerCallbackPrx) _ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     *
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default ServerCallbackPrx ice_connectionCached(boolean newCache) {
        return (ServerCallbackPrx) _ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     *
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default ServerCallbackPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType) {
        return (ServerCallbackPrx) _ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     *
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     *          used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     *          insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default ServerCallbackPrx ice_secure(boolean b) {
        return (ServerCallbackPrx) _ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     *
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default ServerCallbackPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e) {
        return (ServerCallbackPrx) _ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     *
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     *          and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     *          <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default ServerCallbackPrx ice_preferSecure(boolean b) {
        return (ServerCallbackPrx) _ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     *
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default ServerCallbackPrx ice_router(com.zeroc.Ice.RouterPrx router) {
        return (ServerCallbackPrx) _ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     *
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default ServerCallbackPrx ice_locator(com.zeroc.Ice.LocatorPrx locator) {
        return (ServerCallbackPrx) _ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     *
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default ServerCallbackPrx ice_collocationOptimized(boolean b) {
        return (ServerCallbackPrx) _ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     *
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default ServerCallbackPrx ice_twoway() {
        return (ServerCallbackPrx) _ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     *
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default ServerCallbackPrx ice_oneway() {
        return (ServerCallbackPrx) _ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     *
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default ServerCallbackPrx ice_batchOneway() {
        return (ServerCallbackPrx) _ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     *
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default ServerCallbackPrx ice_datagram() {
        return (ServerCallbackPrx) _ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     *
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default ServerCallbackPrx ice_batchDatagram() {
        return (ServerCallbackPrx) _ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     *
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default ServerCallbackPrx ice_compress(boolean co) {
        return (ServerCallbackPrx) _ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     *
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default ServerCallbackPrx ice_timeout(int t) {
        return (ServerCallbackPrx) _ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     *
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default ServerCallbackPrx ice_connectionId(String connectionId) {
        return (ServerCallbackPrx) _ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     *
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default ServerCallbackPrx ice_fixed(com.zeroc.Ice.Connection connection) {
        return (ServerCallbackPrx) _ice_fixed(connection);
    }

    static String ice_staticId() {
        return "::Murmur::ServerCallback";
    }
}