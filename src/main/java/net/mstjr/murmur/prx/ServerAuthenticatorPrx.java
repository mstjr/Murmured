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

import net.mstjr.murmur.helpers.CertificateListHelper;
import net.mstjr.murmur.proxy.server.Server;
import net.mstjr.murmur.proxy.server.ServerAuthenticator;
import net.mstjr.murmur.prxl._ServerAuthenticatorPrxI;
import net.mstjr.murmur.proxy.*;
import net.mstjr.murmur.proxy.callback.ServerCallback;
import net.mstjr.murmur.proxy.callback.ServerContextCallback;

/**
 * Callback interface for server authentication. You need to supply one of these for {@link Server.setAuthenticator}.
 * If an added callback ever throws an exception or goes away, it will be automatically removed.
 * Please note that unlike {@link ServerCallback} and {@link ServerContextCallback}, these methods are called
 * synchronously. If the response lags, the entire murmur server will lag.
 * Also note that, as the method calls are synchronous, making a call to {@link Server} or {@link Meta} will
 * deadlock the server.
 **/
public interface ServerAuthenticatorPrx extends com.zeroc.Ice.ObjectPrx
{
    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     *
     * Internally, Murmur treats usernames as case-insensitive. It is recommended
     * that authenticators do the same. Murmur checks if a username is in use when
     * a user connects. If the connecting user is registered, the other username is
     * kicked. If the connecting user is not registered, the connecting user is not
     * allowed to join the server.
     * @param name Username to authenticate.
     * @param pw Password to authenticate with.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certhash Hash of user certificate, as used by murmur internally when matching.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @return An instance of ServerAuthenticator.AuthenticateResult.
     **/
    default ServerAuthenticator.AuthenticateResult authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong)
    {
        return authenticate(name, pw, certificates, certhash, certstrong, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     *
     * Internally, Murmur treats usernames as case-insensitive. It is recommended
     * that authenticators do the same. Murmur checks if a username is in use when
     * a user connects. If the connecting user is registered, the other username is
     * kicked. If the connecting user is not registered, the connecting user is not
     * allowed to join the server.
     * @param name Username to authenticate.
     * @param pw Password to authenticate with.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certhash Hash of user certificate, as used by murmur internally when matching.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param context The Context map to send with the invocation.
     * @return An instance of ServerAuthenticator.AuthenticateResult.
     **/
    default ServerAuthenticator.AuthenticateResult authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, java.util.Map<String, String> context)
    {
        return _iceI_authenticateAsync(name, pw, certificates, certhash, certstrong, context, true).waitForResponse();
    }

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     *
     * Internally, Murmur treats usernames as case-insensitive. It is recommended
     * that authenticators do the same. Murmur checks if a username is in use when
     * a user connects. If the connecting user is registered, the other username is
     * kicked. If the connecting user is not registered, the connecting user is not
     * allowed to join the server.
     * @param name Username to authenticate.
     * @param pw Password to authenticate with.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certhash Hash of user certificate, as used by murmur internally when matching.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @return A future that will be completed with an instance of ServerAuthenticator.AuthenticateResult.
     **/
    default java.util.concurrent.CompletableFuture<ServerAuthenticator.AuthenticateResult> authenticateAsync(String name, String pw, byte[][] certificates, String certhash, boolean certstrong)
    {
        return _iceI_authenticateAsync(name, pw, certificates, certhash, certstrong, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     *
     * Internally, Murmur treats usernames as case-insensitive. It is recommended
     * that authenticators do the same. Murmur checks if a username is in use when
     * a user connects. If the connecting user is registered, the other username is
     * kicked. If the connecting user is not registered, the connecting user is not
     * allowed to join the server.
     * @param name Username to authenticate.
     * @param pw Password to authenticate with.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certhash Hash of user certificate, as used by murmur internally when matching.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed with an instance of ServerAuthenticator.AuthenticateResult.
     **/
    default java.util.concurrent.CompletableFuture<ServerAuthenticator.AuthenticateResult> authenticateAsync(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, java.util.Map<String, String> context)
    {
        return _iceI_authenticateAsync(name, pw, certificates, certhash, certstrong, context, false);
    }

    /**
     * @hidden
     * @param iceP_name -
     * @param iceP_pw -
     * @param iceP_certificates -
     * @param iceP_certhash -
     * @param iceP_certstrong -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<ServerAuthenticator.AuthenticateResult> _iceI_authenticateAsync(String iceP_name, String iceP_pw, byte[][] iceP_certificates, String iceP_certhash, boolean iceP_certstrong, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<ServerAuthenticator.AuthenticateResult> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "authenticate", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                     ostr.writeString(iceP_pw);
                     CertificateListHelper.write(ostr, iceP_certificates);
                     ostr.writeString(iceP_certhash);
                     ostr.writeBool(iceP_certstrong);
                 }, istr -> {
                     ServerAuthenticator.AuthenticateResult ret = new ServerAuthenticator.AuthenticateResult();
                     ret.read(istr);
                     return ret;
                 });
        return f;
    }

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @return An instance of ServerAuthenticator.GetInfoResult.
     **/
    default ServerAuthenticator.GetInfoResult getInfo(int id)
    {
        return getInfo(id, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param context The Context map to send with the invocation.
     * @return An instance of ServerAuthenticator.GetInfoResult.
     **/
    default ServerAuthenticator.GetInfoResult getInfo(int id, java.util.Map<String, String> context)
    {
        return _iceI_getInfoAsync(id, context, true).waitForResponse();
    }

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @return A future that will be completed with an instance of ServerAuthenticator.GetInfoResult.
     **/
    default java.util.concurrent.CompletableFuture<ServerAuthenticator.GetInfoResult> getInfoAsync(int id)
    {
        return _iceI_getInfoAsync(id, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed with an instance of ServerAuthenticator.GetInfoResult.
     **/
    default java.util.concurrent.CompletableFuture<ServerAuthenticator.GetInfoResult> getInfoAsync(int id, java.util.Map<String, String> context)
    {
        return _iceI_getInfoAsync(id, context, false);
    }

    /**
     * @hidden
     * @param iceP_id -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<ServerAuthenticator.GetInfoResult> _iceI_getInfoAsync(int iceP_id, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<ServerAuthenticator.GetInfoResult> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getInfo", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeInt(iceP_id);
                 }, istr -> {
                     ServerAuthenticator.GetInfoResult ret = new ServerAuthenticator.GetInfoResult();
                     ret.read(istr);
                     return ret;
                 });
        return f;
    }

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @return User id or -2 for unknown name.
     **/
    default int nameToId(String name)
    {
        return nameToId(name, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @param context The Context map to send with the invocation.
     * @return User id or -2 for unknown name.
     **/
    default int nameToId(String name, java.util.Map<String, String> context)
    {
        return _iceI_nameToIdAsync(name, context, true).waitForResponse();
    }

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @return User id or -2 for unknown name.
     **/
    default java.util.concurrent.CompletableFuture<Integer> nameToIdAsync(String name)
    {
        return _iceI_nameToIdAsync(name, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @param context The Context map to send with the invocation.
     * @return User id or -2 for unknown name.
     **/
    default java.util.concurrent.CompletableFuture<Integer> nameToIdAsync(String name, java.util.Map<String, String> context)
    {
        return _iceI_nameToIdAsync(name, context, false);
    }

    /**
     * @hidden
     * @param iceP_name -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Integer> _iceI_nameToIdAsync(String iceP_name, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Integer> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "nameToId", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                 }, istr -> {
                     int ret;
                     ret = istr.readInt();
                     return ret;
                 });
        return f;
    }

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @return Name of user or empty string for unknown id.
     **/
    default String idToName(int id)
    {
        return idToName(id, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @param context The Context map to send with the invocation.
     * @return Name of user or empty string for unknown id.
     **/
    default String idToName(int id, java.util.Map<String, String> context)
    {
        return _iceI_idToNameAsync(id, context, true).waitForResponse();
    }

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @return Name of user or empty string for unknown id.
     **/
    default java.util.concurrent.CompletableFuture<String> idToNameAsync(int id)
    {
        return _iceI_idToNameAsync(id, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @param context The Context map to send with the invocation.
     * @return Name of user or empty string for unknown id.
     **/
    default java.util.concurrent.CompletableFuture<String> idToNameAsync(int id, java.util.Map<String, String> context)
    {
        return _iceI_idToNameAsync(id, context, false);
    }

    /**
     * @hidden
     * @param iceP_id -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<String> _iceI_idToNameAsync(int iceP_id, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<String> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "idToName", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeInt(iceP_id);
                 }, istr -> {
                     String ret;
                     ret = istr.readString();
                     return ret;
                 });
        return f;
    }

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @return User texture or an empty texture for unknown users or users without textures.
     **/
    default byte[] idToTexture(int id)
    {
        return idToTexture(id, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @param context The Context map to send with the invocation.
     * @return User texture or an empty texture for unknown users or users without textures.
     **/
    default byte[] idToTexture(int id, java.util.Map<String, String> context)
    {
        return _iceI_idToTextureAsync(id, context, true).waitForResponse();
    }

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @return User texture or an empty texture for unknown users or users without textures.
     **/
    default java.util.concurrent.CompletableFuture<byte[]> idToTextureAsync(int id)
    {
        return _iceI_idToTextureAsync(id, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @param context The Context map to send with the invocation.
     * @return User texture or an empty texture for unknown users or users without textures.
     **/
    default java.util.concurrent.CompletableFuture<byte[]> idToTextureAsync(int id, java.util.Map<String, String> context)
    {
        return _iceI_idToTextureAsync(id, context, false);
    }

    /**
     * @hidden
     * @param iceP_id -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<byte[]> _iceI_idToTextureAsync(int iceP_id, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<byte[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "idToTexture", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeInt(iceP_id);
                 }, istr -> {
                     byte[] ret;
                     ret = istr.readByteSeq();
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ServerAuthenticatorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), ServerAuthenticatorPrx.class, _ServerAuthenticatorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ServerAuthenticatorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), ServerAuthenticatorPrx.class, _ServerAuthenticatorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ServerAuthenticatorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), ServerAuthenticatorPrx.class, _ServerAuthenticatorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ServerAuthenticatorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), ServerAuthenticatorPrx.class, _ServerAuthenticatorPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static ServerAuthenticatorPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, ServerAuthenticatorPrx.class, _ServerAuthenticatorPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static ServerAuthenticatorPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, ServerAuthenticatorPrx.class, _ServerAuthenticatorPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default ServerAuthenticatorPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (ServerAuthenticatorPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default ServerAuthenticatorPrx ice_adapterId(String newAdapterId)
    {
        return (ServerAuthenticatorPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default ServerAuthenticatorPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (ServerAuthenticatorPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default ServerAuthenticatorPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (ServerAuthenticatorPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default ServerAuthenticatorPrx ice_invocationTimeout(int newTimeout)
    {
        return (ServerAuthenticatorPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default ServerAuthenticatorPrx ice_connectionCached(boolean newCache)
    {
        return (ServerAuthenticatorPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default ServerAuthenticatorPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (ServerAuthenticatorPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default ServerAuthenticatorPrx ice_secure(boolean b)
    {
        return (ServerAuthenticatorPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default ServerAuthenticatorPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (ServerAuthenticatorPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default ServerAuthenticatorPrx ice_preferSecure(boolean b)
    {
        return (ServerAuthenticatorPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default ServerAuthenticatorPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (ServerAuthenticatorPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default ServerAuthenticatorPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (ServerAuthenticatorPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default ServerAuthenticatorPrx ice_collocationOptimized(boolean b)
    {
        return (ServerAuthenticatorPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default ServerAuthenticatorPrx ice_twoway()
    {
        return (ServerAuthenticatorPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default ServerAuthenticatorPrx ice_oneway()
    {
        return (ServerAuthenticatorPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default ServerAuthenticatorPrx ice_batchOneway()
    {
        return (ServerAuthenticatorPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default ServerAuthenticatorPrx ice_datagram()
    {
        return (ServerAuthenticatorPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default ServerAuthenticatorPrx ice_batchDatagram()
    {
        return (ServerAuthenticatorPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default ServerAuthenticatorPrx ice_compress(boolean co)
    {
        return (ServerAuthenticatorPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default ServerAuthenticatorPrx ice_timeout(int t)
    {
        return (ServerAuthenticatorPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default ServerAuthenticatorPrx ice_connectionId(String connectionId)
    {
        return (ServerAuthenticatorPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default ServerAuthenticatorPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (ServerAuthenticatorPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::Murmur::ServerAuthenticator";
    }
}
