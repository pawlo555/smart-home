package pl.edu.agh;

import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import pl.edu.agh.device.MyDevice;

import java.util.List;


public class ServerMain {

    public static void main(String[] args) {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        try {
            server.start();
            server.work();
        }
        finally {
            server.destroyServer();
        }
    }
}
