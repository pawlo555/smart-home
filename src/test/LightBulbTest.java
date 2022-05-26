import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.Commands;
import pl.edu.agh.PairsGenerator;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyDevice;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class LightBulbTest {

    @Test()
    public void lightOffBulbTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("LightBulb1", Commands.TURN_LIGHT_ON);
            assertFalse((boolean) client.command("LightBulb1", Commands.IS_LIGHT_ON));
        }
        finally{
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void lightOnBulbTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("LightBulb1", Commands.TURN_ON);
            client.command("LightBulb1", Commands.TURN_LIGHT_ON);
            assertTrue((boolean) client.command("LightBulb1", Commands.IS_LIGHT_ON));
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void switchingLightBulbTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("LightBulb1", Commands.TURN_ON);
            client.command("LightBulb1", Commands.TURN_LIGHT_ON);
            assertTrue((boolean) client.command("LightBulb1", Commands.IS_LIGHT_ON));
            client.command("LightBulb1", Commands.TURN_LIGHT_OFF);
            assertFalse((boolean) client.command("LightBulb1", Commands.IS_LIGHT_ON));
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }
}
