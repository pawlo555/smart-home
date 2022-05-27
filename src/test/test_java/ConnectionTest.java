package test_java;

import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.PairsGenerator;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyDevice;

import java.util.ArrayList;
import java.util.List;


public class ConnectionTest {
    @Test()
    public void connectionTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Device1");
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void connectionTestTwoServers() {
        String[] firstServerArgs = new String[]{"--Ice.Config=config.server"};
        String[] secondServerArgs = new String[]{"--Ice.Config=config.server_2"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client_2"};
        List<Pair<MyDevice, Identity>> pairListFirstServer = PairsGenerator.getListOfPairTwoServersFirstServer();
        List<Pair<MyDevice, Identity>> pairListSecondServer = PairsGenerator.getListOfPairTwoServersSecondServer();
        List<Pair<MyDevice, Identity>> pairList = new ArrayList<>();
        pairList.addAll(pairListFirstServer);
        pairList.addAll(pairListSecondServer);
        Server firstServer = new Server(firstServerArgs, pairListFirstServer);
        Server secondServer = new Server(secondServerArgs, pairListSecondServer);
        Client client = new Client(customerArgs, pairList);
        try {
            firstServer.start();
            secondServer.start();
            client.start();

            client.command("Device1");
            client.command("LightBulb1");
        }
        finally {
            client.destroyClient();
            secondServer.destroyServer();
            firstServer.destroyServer();
        }
    }
}
