import SmartHome.InvalidTemperature;
import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.Commands;
import pl.edu.agh.PairsGenerator;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyDevice;
import pl.edu.agh.device.MyOven;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class OvenTest {

    @Test()
    public void getTemperatureTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            assertEquals(MyOven.MAX_TEMPERATURE, client.command("Oven1", Commands.GET_MAX_TEMPERATURE));
            assertEquals(MyOven.MIN_TEMPERATURE, client.command("Oven1", Commands.GET_MIN_TEMPERATURE));
            assertEquals(MyOven.MIN_TEMPERATURE, client.command("Oven1", Commands.GET_CURRENT_TEMPERATURE));
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void setInvalidTemperatureTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Oven1", Commands.TURN_ON);
            InvalidTemperature invalidTemperatureException = (InvalidTemperature) client.command("Oven1", Commands.SET_TEMPERATURE, new Object[] {(short)(MyOven.MAX_TEMPERATURE+10)});
            assertEquals(MyOven.MAX_TEMPERATURE+10, invalidTemperatureException.invalidTemperature);
            assertEquals(MyOven.MAX_TEMPERATURE, invalidTemperatureException.maxTemperature);
            assertEquals(MyOven.MIN_TEMPERATURE, invalidTemperatureException.minTemperature);
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void setValidTemperatureTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Oven1", Commands.TURN_ON);
            client.command("Oven1", Commands.SET_TEMPERATURE, new Object[] {(short)(MyOven.MAX_TEMPERATURE-10)});
            short currentTemperature = (short) client.command("Oven1", Commands.GET_CURRENT_TEMPERATURE);
            assertEquals((short)(MyOven.MAX_TEMPERATURE-10), currentTemperature);
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }
}
