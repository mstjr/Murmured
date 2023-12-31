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

import net.mstjr.murmur.helpers.ConfigMapHelper;
import net.mstjr.murmur.proxy.Meta;
import net.mstjr.murmur.proxy.server.Server;
import net.mstjr.murmur.helpers.ServerListHelper;
import net.mstjr.murmur.exceptions.invalid.InvalidCallbackException;
import net.mstjr.murmur.exceptions.invalid.InvalidSecretException;
import net.mstjr.murmur.prxl._MetaPrxI;

/**
 * This is the meta interface. It is primarily used for retrieving the {@link Server} interfaces for each individual server.
 **/
public interface MetaPrx extends com.zeroc.Ice.ObjectPrx {
    /**
     * Fetch interface to specific server.
     *
     * @param id Server ID. See {@link Server.getId}.
     * @return Interface for specified server, or a null proxy if id is invalid.
     **/
    default ServerPrx getServer(int id)
            throws InvalidSecretException {
        return getServer(id, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Fetch interface to specific server.
     *
     * @param id      Server ID. See {@link Server.getId}.
     * @param context The Context map to send with the invocation.
     * @return Interface for specified server, or a null proxy if id is invalid.
     **/
    default ServerPrx getServer(int id, java.util.Map<String, String> context)
            throws InvalidSecretException {
        try {
            return _iceI_getServerAsync(id, context, true).waitForResponseOrUserEx();
        } catch (InvalidSecretException ex) {
            throw ex;
        } catch (com.zeroc.Ice.UserException ex) {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    /**
     * Fetch interface to specific server.
     *
     * @param id Server ID. See {@link Server.getId}.
     * @return Interface for specified server, or a null proxy if id is invalid.
     **/
    default java.util.concurrent.CompletableFuture<ServerPrx> getServerAsync(int id) {
        return _iceI_getServerAsync(id, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Fetch interface to specific server.
     *
     * @param id      Server ID. See {@link Server.getId}.
     * @param context The Context map to send with the invocation.
     * @return Interface for specified server, or a null proxy if id is invalid.
     **/
    default java.util.concurrent.CompletableFuture<ServerPrx> getServerAsync(int id, java.util.Map<String, String> context) {
        return _iceI_getServerAsync(id, context, false);
    }

    /**
     * @param iceP_id -
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<ServerPrx> _iceI_getServerAsync(int iceP_id, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<ServerPrx> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getServer", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_getServer);
        f.invoke(true, context, null, ostr -> {
            ostr.writeInt(iceP_id);
        }, istr -> {
            ServerPrx ret;
            ret = ServerPrx.uncheckedCast(istr.readProxy());
            return ret;
        });
        return f;
    }

    /**
     * @hidden
     */
    Class<?>[] _iceE_getServer =
            {
                    InvalidSecretException.class
            };

    /**
     * Create a new server. Call {@link Server.getId} on the returned interface to find it's ID.
     *
     * @return Interface for new server.
     **/
    default ServerPrx newServer()
            throws InvalidSecretException {
        return newServer(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Create a new server. Call {@link Server.getId} on the returned interface to find it's ID.
     *
     * @param context The Context map to send with the invocation.
     * @return Interface for new server.
     **/
    default ServerPrx newServer(java.util.Map<String, String> context)
            throws InvalidSecretException {
        try {
            return _iceI_newServerAsync(context, true).waitForResponseOrUserEx();
        } catch (InvalidSecretException ex) {
            throw ex;
        } catch (com.zeroc.Ice.UserException ex) {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    /**
     * Create a new server. Call {@link Server.getId} on the returned interface to find it's ID.
     *
     * @return Interface for new server.
     **/
    default java.util.concurrent.CompletableFuture<ServerPrx> newServerAsync() {
        return _iceI_newServerAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Create a new server. Call {@link Server.getId} on the returned interface to find it's ID.
     *
     * @param context The Context map to send with the invocation.
     * @return Interface for new server.
     **/
    default java.util.concurrent.CompletableFuture<ServerPrx> newServerAsync(java.util.Map<String, String> context) {
        return _iceI_newServerAsync(context, false);
    }

    /**
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<ServerPrx> _iceI_newServerAsync(java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<ServerPrx> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "newServer", null, sync, _iceE_newServer);
        f.invoke(true, context, null, null, istr -> {
            ServerPrx ret;
            ret = ServerPrx.uncheckedCast(istr.readProxy());
            return ret;
        });
        return f;
    }

    /**
     * @hidden
     */
    Class<?>[] _iceE_newServer =
            {
                    InvalidSecretException.class
            };

    /**
     * Fetch list of all currently running servers.
     *
     * @return List of interfaces for running servers.
     **/
    default ServerPrx[] getBootedServers()
            throws InvalidSecretException {
        return getBootedServers(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Fetch list of all currently running servers.
     *
     * @param context The Context map to send with the invocation.
     * @return List of interfaces for running servers.
     **/
    default ServerPrx[] getBootedServers(java.util.Map<String, String> context)
            throws InvalidSecretException {
        try {
            return getBootedServerAsync(context, true).waitForResponseOrUserEx();
        } catch (InvalidSecretException ex) {
            throw ex;
        } catch (com.zeroc.Ice.UserException ex) {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    /**
     * Fetch list of all currently running servers.
     *
     * @return List of interfaces for running servers.
     **/
    default java.util.concurrent.CompletableFuture<ServerPrx[]> getBootedServersAsync() {
        return getBootedServerAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Fetch list of all currently running servers.
     *
     * @param context The Context map to send with the invocation.
     * @return List of interfaces for running servers.
     **/
    default java.util.concurrent.CompletableFuture<ServerPrx[]> getBootedServersAsync(java.util.Map<String, String> context) {
        return getBootedServerAsync(context, false);
    }

    /**
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<ServerPrx[]> getBootedServerAsync(java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<ServerPrx[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getBootedServers", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_getBootedServers);
        f.invoke(true, context, null, null, istr -> {
            ServerPrx[] ret;
            ret = ServerListHelper.read(istr);
            return ret;
        });
        return f;
    }

    /**
     * @hidden
     */
    Class<?>[] _iceE_getBootedServers =
            {
                    InvalidSecretException.class
            };

    /**
     * Fetch list of all defined servers.
     *
     * @return List of interfaces for all servers.
     **/
    default ServerPrx[] getAllServers()
            throws InvalidSecretException {
        return getAllServers(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Fetch list of all defined servers.
     *
     * @param context The Context map to send with the invocation.
     * @return List of interfaces for all servers.
     **/
    default ServerPrx[] getAllServers(java.util.Map<String, String> context)
            throws InvalidSecretException {
        try {
            return _iceI_getAllServersAsync(context, true).waitForResponseOrUserEx();
        } catch (InvalidSecretException ex) {
            throw ex;
        } catch (com.zeroc.Ice.UserException ex) {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    /**
     * Fetch list of all defined servers.
     *
     * @return List of interfaces for all servers.
     **/
    default java.util.concurrent.CompletableFuture<ServerPrx[]> getAllServersAsync() {
        return _iceI_getAllServersAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Fetch list of all defined servers.
     *
     * @param context The Context map to send with the invocation.
     * @return List of interfaces for all servers.
     **/
    default java.util.concurrent.CompletableFuture<ServerPrx[]> getAllServersAsync(java.util.Map<String, String> context) {
        return _iceI_getAllServersAsync(context, false);
    }

    /**
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<ServerPrx[]> _iceI_getAllServersAsync(java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<ServerPrx[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getAllServers", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_getAllServers);
        f.invoke(true, context, null, null, istr -> {
            ServerPrx[] ret;
            ret = ServerListHelper.read(istr);
            return ret;
        });
        return f;
    }

    /**
     * @hidden
     */
    Class<?>[] _iceE_getAllServers =
            {
                    InvalidSecretException.class
            };

    /**
     * Fetch default configuration. This returns the configuration items that were set in the configuration file, or
     * the built-in default. The individual servers will use these values unless they have been overridden in the
     * server specific configuration. The only special case is the port, which defaults to the value defined here +
     * the servers ID - 1 (so that virtual server #1 uses the defined port, server #2 uses port+1 etc).
     *
     * @return Default configuration of the servers.
     **/
    default java.util.Map<String, String> getDefaultConf()
            throws InvalidSecretException {
        return getDefaultConf(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Fetch default configuration. This returns the configuration items that were set in the configuration file, or
     * the built-in default. The individual servers will use these values unless they have been overridden in the
     * server specific configuration. The only special case is the port, which defaults to the value defined here +
     * the servers ID - 1 (so that virtual server #1 uses the defined port, server #2 uses port+1 etc).
     *
     * @param context The Context map to send with the invocation.
     * @return Default configuration of the servers.
     **/
    default java.util.Map<String, String> getDefaultConf(java.util.Map<String, String> context)
            throws InvalidSecretException {
        try {
            return _iceI_getDefaultConfAsync(context, true).waitForResponseOrUserEx();
        } catch (InvalidSecretException ex) {
            throw ex;
        } catch (com.zeroc.Ice.UserException ex) {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    /**
     * Fetch default configuration. This returns the configuration items that were set in the configuration file, or
     * the built-in default. The individual servers will use these values unless they have been overridden in the
     * server specific configuration. The only special case is the port, which defaults to the value defined here +
     * the servers ID - 1 (so that virtual server #1 uses the defined port, server #2 uses port+1 etc).
     *
     * @return Default configuration of the servers.
     **/
    default java.util.concurrent.CompletableFuture<java.util.Map<String, String>> getDefaultConfAsync() {
        return _iceI_getDefaultConfAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Fetch default configuration. This returns the configuration items that were set in the configuration file, or
     * the built-in default. The individual servers will use these values unless they have been overridden in the
     * server specific configuration. The only special case is the port, which defaults to the value defined here +
     * the servers ID - 1 (so that virtual server #1 uses the defined port, server #2 uses port+1 etc).
     *
     * @param context The Context map to send with the invocation.
     * @return Default configuration of the servers.
     **/
    default java.util.concurrent.CompletableFuture<java.util.Map<String, String>> getDefaultConfAsync(java.util.Map<String, String> context) {
        return _iceI_getDefaultConfAsync(context, false);
    }

    /**
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.util.Map<String, String>> _iceI_getDefaultConfAsync(java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<java.util.Map<String, String>> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getDefaultConf", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_getDefaultConf);
        f.invoke(true, context, null, null, istr -> {
            java.util.Map<String, String> ret;
            ret = ConfigMapHelper.read(istr);
            return ret;
        });
        return f;
    }

    /**
     * @hidden
     */
    Class<?>[] _iceE_getDefaultConf =
            {
                    InvalidSecretException.class
            };

    /**
     * Fetch version of Murmur.
     *
     * @return An instance of Meta.GetVersionResult.
     **/
    default Meta.GetVersionResult getVersion() {
        return getVersion(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Fetch version of Murmur.
     *
     * @param context The Context map to send with the invocation.
     * @return An instance of Meta.GetVersionResult.
     **/
    default Meta.GetVersionResult getVersion(java.util.Map<String, String> context) {
        return _iceI_getVersionAsync(context, true).waitForResponse();
    }

    /**
     * Fetch version of Murmur.
     *
     * @return A future that will be completed with an instance of Meta.GetVersionResult.
     **/
    default java.util.concurrent.CompletableFuture<Meta.GetVersionResult> getVersionAsync() {
        return _iceI_getVersionAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Fetch version of Murmur.
     *
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed with an instance of Meta.GetVersionResult.
     **/
    default java.util.concurrent.CompletableFuture<Meta.GetVersionResult> getVersionAsync(java.util.Map<String, String> context) {
        return _iceI_getVersionAsync(context, false);
    }

    /**
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Meta.GetVersionResult> _iceI_getVersionAsync(java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Meta.GetVersionResult> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getVersion", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
            Meta.GetVersionResult ret = new Meta.GetVersionResult();
            ret.read(istr);
            return ret;
        });
        return f;
    }

    /**
     * Add a callback. The callback will receive notifications when servers are started or stopped.
     *
     * @param cb Callback interface which will receive notifications.
     **/
    default void addCallback(MetaCallbackPrx cb)
            throws InvalidCallbackException,
            InvalidSecretException {
        addCallback(cb, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Add a callback. The callback will receive notifications when servers are started or stopped.
     *
     * @param cb      Callback interface which will receive notifications.
     * @param context The Context map to send with the invocation.
     **/
    default void addCallback(MetaCallbackPrx cb, java.util.Map<String, String> context)
            throws InvalidCallbackException,
            InvalidSecretException {
        try {
            _iceI_addCallbackAsync(cb, context, true).waitForResponseOrUserEx();
        } catch (InvalidCallbackException ex) {
            throw ex;
        } catch (InvalidSecretException ex) {
            throw ex;
        } catch (com.zeroc.Ice.UserException ex) {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    /**
     * Add a callback. The callback will receive notifications when servers are started or stopped.
     *
     * @param cb Callback interface which will receive notifications.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> addCallbackAsync(MetaCallbackPrx cb) {
        return _iceI_addCallbackAsync(cb, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Add a callback. The callback will receive notifications when servers are started or stopped.
     *
     * @param cb      Callback interface which will receive notifications.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> addCallbackAsync(MetaCallbackPrx cb, java.util.Map<String, String> context) {
        return _iceI_addCallbackAsync(cb, context, false);
    }

    /**
     * @param iceP_cb -
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_addCallbackAsync(MetaCallbackPrx iceP_cb, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "addCallback", null, sync, _iceE_addCallback);
        f.invoke(true, context, null, ostr -> {
            ostr.writeProxy(iceP_cb);
        }, null);
        return f;
    }

    /**
     * @hidden
     */
    Class<?>[] _iceE_addCallback =
            {
                    InvalidCallbackException.class,
                    InvalidSecretException.class
            };

    /**
     * Remove a callback.
     *
     * @param cb Callback interface to be removed.
     **/
    default void removeCallback(MetaCallbackPrx cb)
            throws InvalidCallbackException,
            InvalidSecretException {
        removeCallback(cb, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Remove a callback.
     *
     * @param cb      Callback interface to be removed.
     * @param context The Context map to send with the invocation.
     **/
    default void removeCallback(MetaCallbackPrx cb, java.util.Map<String, String> context)
            throws InvalidCallbackException,
            InvalidSecretException {
        try {
            _iceI_removeCallbackAsync(cb, context, true).waitForResponseOrUserEx();
        } catch (InvalidCallbackException ex) {
            throw ex;
        } catch (InvalidSecretException ex) {
            throw ex;
        } catch (com.zeroc.Ice.UserException ex) {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    /**
     * Remove a callback.
     *
     * @param cb Callback interface to be removed.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> removeCallbackAsync(MetaCallbackPrx cb) {
        return _iceI_removeCallbackAsync(cb, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Remove a callback.
     *
     * @param cb      Callback interface to be removed.
     * @param context The Context map to send with the invocation.
     * @return A future that will be completed when the invocation completes.
     **/
    default java.util.concurrent.CompletableFuture<Void> removeCallbackAsync(MetaCallbackPrx cb, java.util.Map<String, String> context) {
        return _iceI_removeCallbackAsync(cb, context, false);
    }

    /**
     * @param iceP_cb -
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_removeCallbackAsync(MetaCallbackPrx iceP_cb, java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "removeCallback", null, sync, _iceE_removeCallback);
        f.invoke(true, context, null, ostr -> {
            ostr.writeProxy(iceP_cb);
        }, null);
        return f;
    }

    /**
     * @hidden
     */
    Class<?>[] _iceE_removeCallback =
            {
                    InvalidCallbackException.class,
                    InvalidSecretException.class
            };

    /**
     * Get murmur uptime.
     *
     * @return Uptime of murmur in seconds
     **/
    default int getUptime() {
        return getUptime(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Get murmur uptime.
     *
     * @param context The Context map to send with the invocation.
     * @return Uptime of murmur in seconds
     **/
    default int getUptime(java.util.Map<String, String> context) {
        return _iceI_getUptimeAsync(context, true).waitForResponse();
    }

    /**
     * Get murmur uptime.
     *
     * @return Uptime of murmur in seconds
     **/
    default java.util.concurrent.CompletableFuture<Integer> getUptimeAsync() {
        return _iceI_getUptimeAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Get murmur uptime.
     *
     * @param context The Context map to send with the invocation.
     * @return Uptime of murmur in seconds
     **/
    default java.util.concurrent.CompletableFuture<Integer> getUptimeAsync(java.util.Map<String, String> context) {
        return _iceI_getUptimeAsync(context, false);
    }

    /**
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Integer> _iceI_getUptimeAsync(java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<Integer> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getUptime", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
            int ret;
            ret = istr.readInt();
            return ret;
        });
        return f;
    }

    /**
     * Get slice file.
     *
     * @return Contents of the slice file server compiled with.
     **/
    default String getSlice() {
        return getSlice(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    /**
     * Get slice file.
     *
     * @param context The Context map to send with the invocation.
     * @return Contents of the slice file server compiled with.
     **/
    default String getSlice(java.util.Map<String, String> context) {
        return _iceI_getSliceAsync(context, true).waitForResponse();
    }

    /**
     * Get slice file.
     *
     * @return Contents of the slice file server compiled with.
     **/
    default java.util.concurrent.CompletableFuture<String> getSliceAsync() {
        return _iceI_getSliceAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    /**
     * Get slice file.
     *
     * @param context The Context map to send with the invocation.
     * @return Contents of the slice file server compiled with.
     **/
    default java.util.concurrent.CompletableFuture<String> getSliceAsync(java.util.Map<String, String> context) {
        return _iceI_getSliceAsync(context, false);
    }

    /**
     * @param context -
     * @param sync    -
     * @return -
     * @hidden
     **/
    default com.zeroc.IceInternal.OutgoingAsync<String> _iceI_getSliceAsync(java.util.Map<String, String> context, boolean sync) {
        com.zeroc.IceInternal.OutgoingAsync<String> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getSlice", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
            String ret;
            ret = istr.readString();
            return ret;
        });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     *
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static MetaPrx checkedCast(com.zeroc.Ice.ObjectPrx obj) {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), MetaPrx.class, _MetaPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     *
     * @param obj     The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static MetaPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context) {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), MetaPrx.class, _MetaPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     *
     * @param obj   The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static MetaPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet) {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), MetaPrx.class, _MetaPrxI.class);
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
    static MetaPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context) {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), MetaPrx.class, _MetaPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     *
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static MetaPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj) {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, MetaPrx.class, _MetaPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     *
     * @param obj   The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static MetaPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet) {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, MetaPrx.class, _MetaPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     *
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default MetaPrx ice_context(java.util.Map<String, String> newContext) {
        return (MetaPrx) _ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     *
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default MetaPrx ice_adapterId(String newAdapterId) {
        return (MetaPrx) _ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     *
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default MetaPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints) {
        return (MetaPrx) _ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     *
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default MetaPrx ice_locatorCacheTimeout(int newTimeout) {
        return (MetaPrx) _ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     *
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default MetaPrx ice_invocationTimeout(int newTimeout) {
        return (MetaPrx) _ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     *
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default MetaPrx ice_connectionCached(boolean newCache) {
        return (MetaPrx) _ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     *
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default MetaPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType) {
        return (MetaPrx) _ice_endpointSelection(newType);
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
    default MetaPrx ice_secure(boolean b) {
        return (MetaPrx) _ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     *
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default MetaPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e) {
        return (MetaPrx) _ice_encodingVersion(e);
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
    default MetaPrx ice_preferSecure(boolean b) {
        return (MetaPrx) _ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     *
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default MetaPrx ice_router(com.zeroc.Ice.RouterPrx router) {
        return (MetaPrx) _ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     *
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default MetaPrx ice_locator(com.zeroc.Ice.LocatorPrx locator) {
        return (MetaPrx) _ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     *
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default MetaPrx ice_collocationOptimized(boolean b) {
        return (MetaPrx) _ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     *
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default MetaPrx ice_twoway() {
        return (MetaPrx) _ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     *
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default MetaPrx ice_oneway() {
        return (MetaPrx) _ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     *
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default MetaPrx ice_batchOneway() {
        return (MetaPrx) _ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     *
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default MetaPrx ice_datagram() {
        return (MetaPrx) _ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     *
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default MetaPrx ice_batchDatagram() {
        return (MetaPrx) _ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     *
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default MetaPrx ice_compress(boolean co) {
        return (MetaPrx) _ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     *
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default MetaPrx ice_timeout(int t) {
        return (MetaPrx) _ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     *
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default MetaPrx ice_connectionId(String connectionId) {
        return (MetaPrx) _ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     *
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default MetaPrx ice_fixed(com.zeroc.Ice.Connection connection) {
        return (MetaPrx) _ice_fixed(connection);
    }

    static String ice_staticId() {
        return "::Murmur::Meta";
    }
}
