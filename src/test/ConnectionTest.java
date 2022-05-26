import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.PairsGenerator;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyDevice;

import java.util.List;


public class ConnectionTest {
    @Test()
    public void testConnection() {
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
}
