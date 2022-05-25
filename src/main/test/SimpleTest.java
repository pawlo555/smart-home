import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.Server;

import static org.junit.Assert.assertTrue;

public class SimpleTest {


    @Test
    public void simpleTest() {
        Server server = new Server();
        Client client = new Client();

        server.start();
        boolean result = client.command();

        assertTrue(result);
    }
}
