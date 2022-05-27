package pl.edu.agh;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import javafx.util.Pair;
import pl.edu.agh.device.MyDevice;

import java.util.List;

public class Server {
    private Communicator communicator = null;
    private final String[] args;
    private final List<Pair<MyDevice, Identity>> servantIdentityPairs;
    private final String adapterName;

    public Server(String[] args, List<Pair<MyDevice, Identity>> servantIdentityPairs) {
        this.args = args;
        this.servantIdentityPairs = servantIdentityPairs;
        adapterName = "Adapter";
    }

    public Server(String[] args, List<Pair<MyDevice, Identity>> servantIdentityPairs, String adapterName) {
        this.args = args;
        this.servantIdentityPairs = servantIdentityPairs;
        this.adapterName = adapterName;
    }

    public void start() {
        communicator = Util.initialize(args);
        ObjectAdapter adapter = communicator.createObjectAdapter(adapterName);
        addDevices(adapter);
        adapter.activate();
    }

    public void work() {
        System.out.println("Waiting for commands...");
        communicator.waitForShutdown();
    }

    public void addDevices(ObjectAdapter adapter) {
        for (Pair<MyDevice, Identity> pair: servantIdentityPairs) {
            adapter.add(pair.getKey(), pair.getValue());
        }
    }

    public void destroyServer() {
        if (communicator != null) {
            communicator.destroy();
        }
    }
}
