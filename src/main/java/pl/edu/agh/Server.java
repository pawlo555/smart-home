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
    private final List<Pair<MyDevice, Identity>> servantsIdentitiesPair;

    public Server(String[] args, List<Pair<MyDevice, Identity>> servantsIdentitiesPair) {
        this.args = args;
        this.servantsIdentitiesPair = servantsIdentitiesPair;
    }

    public void start() {
        communicator = Util.initialize(args);
        ObjectAdapter adapter = communicator.createObjectAdapter("Adapter");
        adapter.activate();
    }

    public void addDevices(ObjectAdapter adapter) {
        for (Pair<MyDevice, Identity> pair: servantsIdentitiesPair) {
            adapter.add(pair.getKey(), pair.getValue());
        }
    }

    public void destroyServer() {
        if (communicator != null) {
            communicator.destroy();
        }
    }

    public static void main(String[] args)
    {
        //Server app = new Server();
        //app.t1(args);
    }
}
