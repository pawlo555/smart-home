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

public interface OvenPrx extends DevicePrx,
                                 TimerPrx
{
    default short getMaxTemperature()
    {
        return getMaxTemperature(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default short getMaxTemperature(java.util.Map<String, String> context)
    {
        return _iceI_getMaxTemperatureAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Short> getMaxTemperatureAsync()
    {
        return _iceI_getMaxTemperatureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Short> getMaxTemperatureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getMaxTemperatureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Short> _iceI_getMaxTemperatureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Short> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getMaxTemperature", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     short ret;
                     ret = istr.readShort();
                     return ret;
                 });
        return f;
    }

    default short getMinTemperature()
    {
        return getMinTemperature(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default short getMinTemperature(java.util.Map<String, String> context)
    {
        return _iceI_getMinTemperatureAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Short> getMinTemperatureAsync()
    {
        return _iceI_getMinTemperatureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Short> getMinTemperatureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getMinTemperatureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Short> _iceI_getMinTemperatureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Short> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getMinTemperature", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     short ret;
                     ret = istr.readShort();
                     return ret;
                 });
        return f;
    }

    default short getCurrentTemperature()
    {
        return getCurrentTemperature(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default short getCurrentTemperature(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentTemperatureAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Short> getCurrentTemperatureAsync()
    {
        return _iceI_getCurrentTemperatureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Short> getCurrentTemperatureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentTemperatureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Short> _iceI_getCurrentTemperatureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Short> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getCurrentTemperature", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     short ret;
                     ret = istr.readShort();
                     return ret;
                 });
        return f;
    }

    default void setTemperature(short newTemperature)
        throws InvalidTemperature
    {
        setTemperature(newTemperature, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setTemperature(short newTemperature, java.util.Map<String, String> context)
        throws InvalidTemperature
    {
        try
        {
            _iceI_setTemperatureAsync(newTemperature, context, true).waitForResponseOrUserEx();
        }
        catch(InvalidTemperature ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> setTemperatureAsync(short newTemperature)
    {
        return _iceI_setTemperatureAsync(newTemperature, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setTemperatureAsync(short newTemperature, java.util.Map<String, String> context)
    {
        return _iceI_setTemperatureAsync(newTemperature, context, false);
    }

    /**
     * @hidden
     * @param iceP_newTemperature -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setTemperatureAsync(short iceP_newTemperature, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setTemperature", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_setTemperature);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeShort(iceP_newTemperature);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_setTemperature =
    {
        InvalidTemperature.class
    };

    default Modes[] getSupportedModes()
    {
        return getSupportedModes(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Modes[] getSupportedModes(java.util.Map<String, String> context)
    {
        return _iceI_getSupportedModesAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Modes[]> getSupportedModesAsync()
    {
        return _iceI_getSupportedModesAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Modes[]> getSupportedModesAsync(java.util.Map<String, String> context)
    {
        return _iceI_getSupportedModesAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Modes[]> _iceI_getSupportedModesAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Modes[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getSupportedModes", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Modes[] ret;
                     ret = ModesSequenceHelper.read(istr);
                     return ret;
                 });
        return f;
    }

    default Modes getCurrentMode()
    {
        return getCurrentMode(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Modes getCurrentMode(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentModeAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Modes> getCurrentModeAsync()
    {
        return _iceI_getCurrentModeAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Modes> getCurrentModeAsync(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentModeAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Modes> _iceI_getCurrentModeAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Modes> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getCurrentMode", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Modes ret;
                     ret = Modes.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default void setMode(Modes mode)
        throws UnsupportedMode
    {
        setMode(mode, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setMode(Modes mode, java.util.Map<String, String> context)
        throws UnsupportedMode
    {
        try
        {
            _iceI_setModeAsync(mode, context, true).waitForResponseOrUserEx();
        }
        catch(UnsupportedMode ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> setModeAsync(Modes mode)
    {
        return _iceI_setModeAsync(mode, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setModeAsync(Modes mode, java.util.Map<String, String> context)
    {
        return _iceI_setModeAsync(mode, context, false);
    }

    /**
     * @hidden
     * @param iceP_mode -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setModeAsync(Modes iceP_mode, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setMode", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_setMode);
        f.invoke(true, context, null, ostr -> {
                     Modes.ice_write(ostr, iceP_mode);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_setMode =
    {
        UnsupportedMode.class
    };

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static OvenPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), OvenPrx.class, _OvenPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static OvenPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), OvenPrx.class, _OvenPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static OvenPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), OvenPrx.class, _OvenPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static OvenPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), OvenPrx.class, _OvenPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static OvenPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, OvenPrx.class, _OvenPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static OvenPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, OvenPrx.class, _OvenPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default OvenPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (OvenPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default OvenPrx ice_adapterId(String newAdapterId)
    {
        return (OvenPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default OvenPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (OvenPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default OvenPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (OvenPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default OvenPrx ice_invocationTimeout(int newTimeout)
    {
        return (OvenPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default OvenPrx ice_connectionCached(boolean newCache)
    {
        return (OvenPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default OvenPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (OvenPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default OvenPrx ice_secure(boolean b)
    {
        return (OvenPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default OvenPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (OvenPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default OvenPrx ice_preferSecure(boolean b)
    {
        return (OvenPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default OvenPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (OvenPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default OvenPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (OvenPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default OvenPrx ice_collocationOptimized(boolean b)
    {
        return (OvenPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default OvenPrx ice_twoway()
    {
        return (OvenPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default OvenPrx ice_oneway()
    {
        return (OvenPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default OvenPrx ice_batchOneway()
    {
        return (OvenPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default OvenPrx ice_datagram()
    {
        return (OvenPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default OvenPrx ice_batchDatagram()
    {
        return (OvenPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default OvenPrx ice_compress(boolean co)
    {
        return (OvenPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default OvenPrx ice_timeout(int t)
    {
        return (OvenPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default OvenPrx ice_connectionId(String connectionId)
    {
        return (OvenPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default OvenPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (OvenPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::SmartHome::Oven";
    }
}
