import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyDevice;

import java.util.Collections;


public class ConnectionTest {
    @Test()
    public void testConnection() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        Pair<MyDevice, Identity> pair = new Pair<>(new MyDevice(), new Identity("Device1", "devices"));
        Server server = new Server(serverArgs, Collections.singletonList(pair));
        server.start();
        Client client = new Client(customerArgs, Collections.singletonList(pair));
        client.start();

        client.command("Device1");

        client.destroyClient();
        server.destroyServer();
    }
}
