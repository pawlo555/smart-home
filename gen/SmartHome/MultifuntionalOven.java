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

public interface MultifuntionalOven extends Oven
{
    short getTemperatureInsideOven(com.zeroc.Ice.Current current);

    short getHumidityInsideOven(com.zeroc.Ice.Current current);

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Ice::Object",
        "::SmartHome::Device",
        "::SmartHome::MultifuntionalOven",
        "::SmartHome::Oven",
        "::SmartHome::Timer"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::SmartHome::MultifuntionalOven";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getTemperatureInsideOven(MultifuntionalOven obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        inS.readEmptyParams();
        short ret = obj.getTemperatureInsideOven(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeShort(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getHumidityInsideOven(MultifuntionalOven obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        inS.readEmptyParams();
        short ret = obj.getHumidityInsideOven(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeShort(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "getCurrentTemperature",
        "getHumidityInsideOven",
        "getMaxTemperature",
        "getMinTemperature",
        "getName",
        "getSupportedModes",
        "getTemperatureInsideOven",
        "getTime",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "isFinish",
        "isTurnedOn",
        "resetTimer",
        "setCurrentTemperature",
        "setTime",
        "setTo",
        "start",
        "stop"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return Oven._iceD_getCurrentTemperature(this, in, current);
            }
            case 1:
            {
                return _iceD_getHumidityInsideOven(this, in, current);
            }
            case 2:
            {
                return Oven._iceD_getMaxTemperature(this, in, current);
            }
            case 3:
            {
                return Oven._iceD_getMinTemperature(this, in, current);
            }
            case 4:
            {
                return Device._iceD_getName(this, in, current);
            }
            case 5:
            {
                return Oven._iceD_getSupportedModes(this, in, current);
            }
            case 6:
            {
                return _iceD_getTemperatureInsideOven(this, in, current);
            }
            case 7:
            {
                return Timer._iceD_getTime(this, in, current);
            }
            case 8:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 9:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 10:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 11:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 12:
            {
                return Timer._iceD_isFinish(this, in, current);
            }
            case 13:
            {
                return Device._iceD_isTurnedOn(this, in, current);
            }
            case 14:
            {
                return Timer._iceD_resetTimer(this, in, current);
            }
            case 15:
            {
                return Oven._iceD_setCurrentTemperature(this, in, current);
            }
            case 16:
            {
                return Timer._iceD_setTime(this, in, current);
            }
            case 17:
            {
                return Device._iceD_setTo(this, in, current);
            }
            case 18:
            {
                return Timer._iceD_start(this, in, current);
            }
            case 19:
            {
                return Timer._iceD_stop(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
