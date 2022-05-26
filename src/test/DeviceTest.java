import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.Commands;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyDevice;

import java.util.Collections;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class DeviceTest {

    @Test()
    public void testDeviceFirstTurnOff() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        Pair<MyDevice, Identity> pair = new Pair<>(new MyDevice(), new Identity("Device1", "devices"));
        Server server = new Server(serverArgs, Collections.singletonList(pair));
        server.start();
        Client client = new Client(customerArgs, Collections.singletonList(pair));
        client.start();

        assertFalse((Boolean) client.command("Device1", Commands.CHECK_POWER));

        client.destroyClient();
        server.destroyServer();
    }

    @Test()
    public void deviceAfterTurnOnIsOn() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        Pair<MyDevice, Identity> pair = new Pair<>(new MyDevice(), new Identity("Device1", "devices"));
        Server server = new Server(serverArgs, Collections.singletonList(pair));
        server.start();
        Client client = new Client(customerArgs, Collections.singletonList(pair));
        client.start();

        client.command("Device1", Commands.TURN_ON);
        assertTrue((Boolean) client.command("Device1", Commands.CHECK_POWER));

        client.destroyClient();
        server.destroyServer();
    }

    @Test()
    public void switchingDevice() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        Pair<MyDevice, Identity> pair = new Pair<>(new MyDevice(), new Identity("Device1", "devices"));
        Server server = new Server(serverArgs, Collections.singletonList(pair));
        server.start();
        Client client = new Client(customerArgs, Collections.singletonList(pair));
        client.start();

        client.command("Device1", Commands.TURN_ON);
        client.command("Device1", Commands.TURN_OFF);
        client.command("Device1", Commands.TURN_OFF);
        assertFalse((Boolean) client.command("Device1", Commands.CHECK_POWER));

        client.destroyClient();
        server.destroyServer();
    }

}
