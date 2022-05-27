package client

import SmartHome.CameraPrx
import SmartHome.DevicePrx
import SmartHome.InvalidPhotoSize
import SmartHome.InvalidTemperature
import SmartHome.InvalidTime
import SmartHome.LightBulbPrx
import SmartHome.Modes
import SmartHome.MultifunctionalOvenPrx
import SmartHome.OvenPrx
import SmartHome.PhotoSize
import SmartHome.PowerState
import SmartHome.Time
import SmartHome.UnsupportedMode
import com.zeroc.Ice.Communicator
import com.zeroc.Ice.Identity
import com.zeroc.Ice.Util
import javafx.util.Pair
import pl.edu.agh.Commands
import pl.edu.agh.device.MyDevice

class ClientConnection {
    private Communicator communicator = null
    private final String[] args
    private final List<Pair<MyDevice, Identity>> servantIdentityPairs
    private final Map<String, DevicePrx> identitiesMap = new HashMap<>()

    ClientConnection(String[] args, List<Pair<MyDevice, Identity>> servantsIdentityPair) {
        this.args = args
        this.servantIdentityPairs = servantsIdentityPair
    }

    void start() {
        communicator = Util.initialize(args)
        collectObjects()
    }

    void collectObjects() {
        for (Pair<MyDevice, Identity> pair: servantIdentityPairs) {
            String key = pair.getValue().name
            DevicePrx proxy = DevicePrx.checkedCast(communicator.propertyToProxy(pair.getValue().name + ".Proxy"))
            identitiesMap.put(key, proxy)
        }
    }

    void destroyClient() {
        if (communicator != null) {
            communicator.destroy()
        }
    }

    Object command(String name, Commands command) {
        DevicePrx proxy = identitiesMap.get(name)
        switch(command) {
            case Commands.TURN_ON:
                proxy.setTo(PowerState.ON)
                return null
            case Commands.TURN_OFF:
                proxy.setTo(PowerState.OFF)
                return null
            case Commands.CHECK_POWER:
                return proxy.isTurnedOn()
            case Commands.GET_PHOTO:
                CameraPrx cameraPrx = CameraPrx.checkedCast(proxy)
                return cameraPrx.getPhoto()
            case Commands.GET_PHOTO_SIZE:
                CameraPrx cameraPrx = CameraPrx.checkedCast(proxy)
                return cameraPrx.getPhotoSize()
            case Commands.IS_LIGHT_ON:
                LightBulbPrx lightBulbPrx = LightBulbPrx.checkedCast(proxy)
                return lightBulbPrx.isLighting()
            case Commands.TURN_LIGHT_ON:
                LightBulbPrx lightBulbPrx = LightBulbPrx.checkedCast(proxy)
                lightBulbPrx.turnLightOn()
                return null
            case Commands.TURN_LIGHT_OFF:
                LightBulbPrx lightBulbPrx = LightBulbPrx.checkedCast(proxy)
                lightBulbPrx.turnLightOff()
                return null
            case Commands.GET_MAX_TEMPERATURE:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                return ovenPrx.getMaxTemperature()
            case Commands.GET_MIN_TEMPERATURE:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                return ovenPrx.getMinTemperature()
            case Commands.GET_CURRENT_TEMPERATURE:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                return ovenPrx.getCurrentTemperature()
            case Commands.GET_CURRENT_MODE:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                return ovenPrx.getCurrentMode()
            case Commands.GET_SUPPORTED_MODES:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                return ovenPrx.getSupportedModes()
            case Commands.START:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                ovenPrx.start()
                return null
            case Commands.STOP:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                ovenPrx.stop()
                return null
            case Commands.RESET:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                ovenPrx.resetTimer()
                return null
            case Commands.GET_TIME:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                return ovenPrx.getTime()
            case Commands.IS_FINISH:
                OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                return ovenPrx.isFinish()
            case Commands.GET_HUMIDITY:
                MultifunctionalOvenPrx multifunctionalOvenPrx = MultifunctionalOvenPrx.checkedCast(proxy)
                return multifunctionalOvenPrx.getHumidityInsideOven()
            case Commands.GET_OVEN_TEMPERATURE:
                MultifunctionalOvenPrx multifunctionalOvenPrx = MultifunctionalOvenPrx.checkedCast(proxy)
                return multifunctionalOvenPrx.getTemperatureInsideOven()
        }
    }

    Object command(String name, Commands command, Object param) {
        DevicePrx proxy = identitiesMap.get(name)
        try {
            switch (command) {
                case Commands.SET_PHOTO_SIZE:
                    PhotoSize newPhotoSize = (PhotoSize) param
                    CameraPrx cameraPrx = CameraPrx.checkedCast(proxy)
                    cameraPrx.setPhotoSize(newPhotoSize)
                    return null
                case Commands.SET_TEMPERATURE:
                    short newTemperature = (short) param
                    OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                    ovenPrx.setTemperature(newTemperature)
                    return null
                case Commands.SET_MODE:
                    Modes mode = (Modes) param
                    OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                    ovenPrx.setMode(mode)
                    return null
                case Commands.SET_TIME:
                    Time time = (Time) param
                    OvenPrx ovenPrx = OvenPrx.checkedCast(proxy)
                    ovenPrx.setTime(time)
                    return null
            }
        }
        catch (InvalidTemperature | InvalidPhotoSize | UnsupportedMode | InvalidTime exception) {
            return exception
        }
    }

    List<String> getDevices() {
        List<String> devices = []
        for (Pair<MyDevice, Identity> pair in servantIdentityPairs) {
            devices.add(pair.value.name)
        }
        return devices
    }
}
