package test_java;

import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.Commands;
import pl.edu.agh.PairsGenerator;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyDevice;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeviceTest {

    @Test()
    public void testDeviceFirstTurnOffTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            assertFalse((Boolean) client.command("Device1", Commands.CHECK_POWER));
        }
        finally{
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void deviceAfterTurnOnIsOnTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Device1", Commands.TURN_ON);
            assertTrue((Boolean) client.command("Device1", Commands.CHECK_POWER));
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }

    }

    @Test()
    public void switchingDeviceTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Device1", Commands.TURN_ON);
            client.command("Device1", Commands.TURN_OFF);
            client.command("Device1", Commands.TURN_OFF);
            assertFalse((Boolean) client.command("Device1", Commands.CHECK_POWER));
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

}
