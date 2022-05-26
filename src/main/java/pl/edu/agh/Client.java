package pl.edu.agh;

import SmartHome.*;

import com.zeroc.Ice.*;
import javafx.util.Pair;
import pl.edu.agh.device.MyDevice;

import java.lang.Object;
import java.util.HashMap;
import java.util.List;

public class Client
{
    private Communicator communicator = null;
    private final String[] args;
    private final List<Pair<MyDevice, Identity>> servantIdentityPairs;
    private final HashMap<String, DevicePrx> identitiesMap = new HashMap<>();

    public Client(String[] args, List<Pair<MyDevice, Identity>> servantsIdentityPair) {
        this.args = args;
        this.servantIdentityPairs = servantsIdentityPair;
    }

    public void start() {
        communicator = Util.initialize(args);
        collectObjects();
    }

    public void collectObjects() {
        for (Pair<MyDevice, Identity> pair: servantIdentityPairs) {
            String key = pair.getValue().name;
            System.out.println(pair.getValue().name + ".Proxy");
            DevicePrx proxy = DevicePrx.checkedCast(communicator.propertyToProxy(pair.getValue().name + ".Proxy"));
            identitiesMap.put(key, proxy);
        }
    }

    public void destroyClient() {
        if (communicator != null) {
            communicator.destroy();
        }
    }

    public Object command(String name) {
        System.out.println(identitiesMap);
        return identitiesMap.get(name).isTurnedOn();
    }

    public Object command(String name, Commands command) {
        DevicePrx proxy = identitiesMap.get(name);

        switch(command) {
            case TURN_ON -> {
                proxy.setTo(PowerState.ON);
                return null;
            }
            case TURN_OFF -> {
                proxy.setTo(PowerState.OFF);
                return null;
            }
            case CHECK_POWER -> {
                return proxy.isTurnedOn();
            }
            case GET_PHOTO -> {
                CameraPrx cameraPrx = CameraPrx.checkedCast(proxy);
                return cameraPrx.getPhoto();
            }
            case GET_PHOTO_SIZE -> {
                CameraPrx cameraPrx = CameraPrx.checkedCast(proxy);
                return cameraPrx.getPhotoSize();
            }
        }
        return null;
    }

    public Object command(String name, Commands command, Object[] params) throws InvalidPhotoSize {
        DevicePrx proxy = identitiesMap.get(name);
        switch (command) {
            case SET_PHOTO_SIZE -> {
                PhotoSize newPhotoSize = (PhotoSize) params[0];
                CameraPrx cameraPrx = CameraPrx.checkedCast(proxy);
                cameraPrx.setPhotoSize(newPhotoSize);
                return null;
            }
        }
        return null;
    }
}
