import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyDevice;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class SimpleTest {


    @Test
    public void simpleTest() {
        String[] serverArgs = new String[] {"--Ice.Config=server.config"};
        String[] customerArgs = new String[] {"--Ice.Config=server.config"};
        Pair<MyDevice, Identity> pair = new Pair<>(new MyDevice(), new Identity("device1", "devices"));
        Server server = new Server(serverArgs, Collections.singletonList(pair));
        Client client = new Client(customerArgs, Collections.singletonList(pair) );

        server.start();
        boolean result = client.command();
        server.destroyServer();
        assertTrue(result);
    }
}
