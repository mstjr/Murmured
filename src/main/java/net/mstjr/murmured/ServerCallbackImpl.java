package net.mstjr.murmured;

import com.zeroc.Ice.*;
import com.zeroc.Ice.Object;
import com.zeroc.IceInternal.Reference;
import net.mstjr.murmur.prx.ServerCallbackPrx;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class ServerCallbackImpl implements ServerCallbackPrx {

    private MurmurProxy proxy;
    private UUID uuid;

    public ServerCallbackImpl(MurmurProxy proxy) {
        this.proxy = proxy;
        this.uuid = UUID.randomUUID();
    }

    @Override
    public Communicator ice_getCommunicator() {
        return proxy.getMeta().ice_getCommunicator();
    }

    @Override
    public boolean ice_isA(String id) {
        return proxy.getMeta().ice_isA(id);
    }

    @Override
    public boolean ice_isA(String id, Map<String, String> context) {
        return proxy.getMeta().ice_isA(id, context);
    }

    @Override
    public CompletableFuture<Boolean> ice_isAAsync(String id) {
        return proxy.getMeta().ice_isAAsync(id);
    }

    @Override
    public CompletableFuture<Boolean> ice_isAAsync(String id, Map<String, String> context) {
        return proxy.getMeta().ice_isAAsync(id, context);
    }

    @Override
    public void ice_ping() {
        proxy.getMeta().ice_ping();
    }

    @Override
    public void ice_ping(Map<String, String> context) {
        proxy.getMeta().ice_ping(context);
    }

    @Override
    public CompletableFuture<Void> ice_pingAsync() {
        return proxy.getMeta().ice_pingAsync();
    }

    @Override
    public CompletableFuture<Void> ice_pingAsync(Map<String, String> context) {
        return proxy.getMeta().ice_pingAsync(context);
    }

    @Override
    public String[] ice_ids() {
        return proxy.getMeta().ice_ids();
    }

    @Override
    public String[] ice_ids(Map<String, String> context) {
        return proxy.getMeta().ice_ids(context);
    }

    @Override
    public CompletableFuture<String[]> ice_idsAsync() {
        return proxy.getMeta().ice_idsAsync();
    }

    @Override
    public CompletableFuture<String[]> ice_idsAsync(Map<String, String> context) {
        return proxy.getMeta().ice_idsAsync(context);
    }

    @Override
    public String ice_id() {
        return proxy.getMeta().ice_id();
    }

    @Override
    public String ice_id(Map<String, String> context) {
        return proxy.getMeta().ice_id(context);
    }

    @Override
    public CompletableFuture<String> ice_idAsync() {
        return proxy.getMeta().ice_idAsync();
    }

    @Override
    public CompletableFuture<String> ice_idAsync(Map<String, String> context) {
        return proxy.getMeta().ice_idAsync(context);
    }

    @Override
    public Object.Ice_invokeResult ice_invoke(String operation, OperationMode mode, byte[] inParams) {
        return proxy.getMeta().ice_invoke(operation, mode, inParams);
    }

    @Override
    public Object.Ice_invokeResult ice_invoke(String operation, OperationMode mode, byte[] inParams, Map<String, String> context) {
        return proxy.getMeta().ice_invoke(operation, mode, inParams, context);
    }

    @Override
    public CompletableFuture<Object.Ice_invokeResult> ice_invokeAsync(String operation, OperationMode mode, byte[] inParams) {
        return proxy.getMeta().ice_invokeAsync(operation, mode, inParams);
    }

    @Override
    public CompletableFuture<Object.Ice_invokeResult> ice_invokeAsync(String operation, OperationMode mode, byte[] inParams, Map<String, String> context) {
        return proxy.getMeta().ice_invokeAsync(operation, mode, inParams, context);
    }

    @Override
    public Identity ice_getIdentity() {
        return proxy.getMeta().ice_getIdentity();
    }

    @Override
    public ObjectPrx ice_identity(Identity newIdentity) {
        return proxy.getMeta().ice_identity(newIdentity);
    }

    @Override
    public Map<String, String> ice_getContext() {
        return proxy.getMeta().ice_getContext();
    }

    @Override
    public String ice_getFacet() {
        return proxy.getMeta().ice_getFacet();
    }

    @Override
    public ObjectPrx ice_facet(String newFacet) {
        return proxy.getMeta().ice_facet(newFacet);
    }

    @Override
    public String ice_getAdapterId() {
        return proxy.getMeta().ice_getAdapterId();
    }

    @Override
    public Endpoint[] ice_getEndpoints() {
        return proxy.getMeta().ice_getEndpoints();
    }

    @Override
    public int ice_getLocatorCacheTimeout() {
        return proxy.getMeta().ice_getLocatorCacheTimeout();
    }

    @Override
    public int ice_getInvocationTimeout() {
        return proxy.getMeta().ice_getInvocationTimeout();
    }

    @Override
    public String ice_getConnectionId() {
        return proxy.getMeta().ice_getConnectionId();
    }

    @Override
    public boolean ice_isConnectionCached() {
        return proxy.getMeta().ice_isConnectionCached();
    }

    @Override
    public EndpointSelectionType ice_getEndpointSelection() {
        return proxy.getMeta().ice_getEndpointSelection();
    }

    @Override
    public boolean ice_isSecure() {
        return proxy.getMeta().ice_isSecure();
    }

    @Override
    public EncodingVersion ice_getEncodingVersion() {
        return proxy.getMeta().ice_getEncodingVersion();
    }

    @Override
    public boolean ice_isPreferSecure() {
        return proxy.getMeta().ice_isPreferSecure();
    }

    @Override
    public RouterPrx ice_getRouter() {
        return proxy.getMeta().ice_getRouter();
    }

    @Override
    public LocatorPrx ice_getLocator() {
        return proxy.getMeta().ice_getLocator();
    }

    @Override
    public boolean ice_isCollocationOptimized() {
        return proxy.getMeta().ice_isCollocationOptimized();
    }

    @Override
    public boolean ice_isTwoway() {
        return proxy.getMeta().ice_isTwoway();
    }

    @Override
    public boolean ice_isOneway() {
        return proxy.getMeta().ice_isOneway();
    }

    @Override
    public boolean ice_isBatchOneway() {
        return proxy.getMeta().ice_isBatchOneway();
    }

    @Override
    public boolean ice_isDatagram() {
        return proxy.getMeta().ice_isDatagram();
    }

    @Override
    public boolean ice_isBatchDatagram() {
        return proxy.getMeta().ice_isBatchDatagram();
    }

    @Override
    public Optional<Boolean> ice_getCompress() {
        return proxy.getMeta().ice_getCompress();
    }

    @Override
    public OptionalInt ice_getTimeout() {
        return proxy.getMeta().ice_getTimeout();
    }

    @Override
    public Connection ice_getConnection() {
        return proxy.getMeta().ice_getConnection();
    }

    @Override
    public CompletableFuture<Connection> ice_getConnectionAsync() {
        return proxy.getMeta().ice_getConnectionAsync();
    }

    @Override
    public Connection ice_getCachedConnection() {
        return proxy.getMeta().ice_getCachedConnection();
    }

    @Override
    public void ice_flushBatchRequests() {
        proxy.getMeta().ice_flushBatchRequests();
    }

    @Override
    public CompletableFuture<Void> ice_flushBatchRequestsAsync() {
        return proxy.getMeta().ice_flushBatchRequestsAsync();
    }

    @Override
    public void _write(OutputStream os) {
        proxy.getMeta()._write(os);
    }

    @Override
    public void _copyFrom(ObjectPrx p) {
        proxy.getMeta()._copyFrom(p);
    }

    @Override
    public Reference _getReference() {
        return proxy.getMeta()._getReference();
    }

    @Override
    public ObjectPrx _newInstance(Reference r) {
        return proxy.getMeta()._newInstance(r);
    }
}
