//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `SmartHome.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public interface CameraPrx extends DevicePrx
{
    default PhotoSize getPhotoSize()
    {
        return getPhotoSize(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default PhotoSize getPhotoSize(java.util.Map<String, String> context)
    {
        return _iceI_getPhotoSizeAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<PhotoSize> getPhotoSizeAsync()
    {
        return _iceI_getPhotoSizeAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<PhotoSize> getPhotoSizeAsync(java.util.Map<String, String> context)
    {
        return _iceI_getPhotoSizeAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<PhotoSize> _iceI_getPhotoSizeAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<PhotoSize> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getPhotoSize", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     PhotoSize ret;
                     ret = PhotoSize.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default void setPhotoSize(PhotoSize photoSize)
        throws InvalidPhotoSize
    {
        setPhotoSize(photoSize, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setPhotoSize(PhotoSize photoSize, java.util.Map<String, String> context)
        throws InvalidPhotoSize
    {
        try
        {
            _iceI_setPhotoSizeAsync(photoSize, context, true).waitForResponseOrUserEx();
        }
        catch(InvalidPhotoSize ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> setPhotoSizeAsync(PhotoSize photoSize)
    {
        return _iceI_setPhotoSizeAsync(photoSize, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setPhotoSizeAsync(PhotoSize photoSize, java.util.Map<String, String> context)
    {
        return _iceI_setPhotoSizeAsync(photoSize, context, false);
    }

    /**
     * @hidden
     * @param iceP_photoSize -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setPhotoSizeAsync(PhotoSize iceP_photoSize, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setPhotoSize", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_setPhotoSize);
        f.invoke(true, context, null, ostr -> {
                     PhotoSize.ice_write(ostr, iceP_photoSize);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_setPhotoSize =
    {
        InvalidPhotoSize.class
    };

    default short[] getPhoto()
    {
        return getPhoto(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default short[] getPhoto(java.util.Map<String, String> context)
    {
        return _iceI_getPhotoAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<short[]> getPhotoAsync()
    {
        return _iceI_getPhotoAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<short[]> getPhotoAsync(java.util.Map<String, String> context)
    {
        return _iceI_getPhotoAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<short[]> _iceI_getPhotoAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<short[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getPhoto", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     short[] ret;
                     ret = istr.readShortSeq();
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
    static CameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static CameraPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static CameraPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default CameraPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (CameraPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default CameraPrx ice_adapterId(String newAdapterId)
    {
        return (CameraPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default CameraPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (CameraPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default CameraPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (CameraPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default CameraPrx ice_invocationTimeout(int newTimeout)
    {
        return (CameraPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default CameraPrx ice_connectionCached(boolean newCache)
    {
        return (CameraPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default CameraPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (CameraPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default CameraPrx ice_secure(boolean b)
    {
        return (CameraPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default CameraPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (CameraPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default CameraPrx ice_preferSecure(boolean b)
    {
        return (CameraPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default CameraPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (CameraPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default CameraPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (CameraPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default CameraPrx ice_collocationOptimized(boolean b)
    {
        return (CameraPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default CameraPrx ice_twoway()
    {
        return (CameraPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default CameraPrx ice_oneway()
    {
        return (CameraPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default CameraPrx ice_batchOneway()
    {
        return (CameraPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default CameraPrx ice_datagram()
    {
        return (CameraPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default CameraPrx ice_batchDatagram()
    {
        return (CameraPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default CameraPrx ice_compress(boolean co)
    {
        return (CameraPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default CameraPrx ice_timeout(int t)
    {
        return (CameraPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default CameraPrx ice_connectionId(String connectionId)
    {
        return (CameraPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default CameraPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (CameraPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::SmartHome::Camera";
    }
}
