package pl.edu.agh;

import SmartHome.*;

import com.zeroc.Ice.*;
import javafx.util.Pair;
import pl.edu.agh.device.MyDevice;

import java.lang.Exception;
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

    public boolean command(String name) {
        System.out.println(identitiesMap);
        return identitiesMap.get(name).isTurnedOn();
    }


}
