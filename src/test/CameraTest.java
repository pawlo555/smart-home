import SmartHome.InvalidPhotoSize;
import SmartHome.PhotoSize;
import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import org.junit.Test;
import pl.edu.agh.Client;
import pl.edu.agh.Commands;
import pl.edu.agh.PairsGenerator;
import pl.edu.agh.Server;
import pl.edu.agh.device.MyCamera;
import pl.edu.agh.device.MyDevice;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CameraTest {
    @Test()
    public void turnOnCameraTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Camera1", Commands.TURN_ON);
            assertTrue((Boolean) client.command("Camera1", Commands.CHECK_POWER));
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void getDefaultPhotoTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Camera1", Commands.TURN_ON);
            short[] photoBytes = (short[]) client.command("Camera1", Commands.GET_PHOTO);

            assertEquals(MyCamera.BASIC_PHOTO_SIZE_X *MyCamera.BASIC_PHOTO_SIZE_Y, photoBytes.length);
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void getPhotoOnOffCameraTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            short[] result = (short[]) client.command("Camera1", Commands.GET_PHOTO);
            assertEquals(0, result.length);
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void changePhotoSizeToInvalidValueTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Camera1", Commands.TURN_ON);
            InvalidPhotoSize invalidPhotoSizeException = (InvalidPhotoSize) client.command("Camera1", Commands.SET_PHOTO_SIZE, new PhotoSize[]{new PhotoSize((short)40, (short)-1)});
            assertEquals(40, invalidPhotoSizeException.invalidPhotoSize.x);
            assertEquals(-1, invalidPhotoSizeException.invalidPhotoSize.y);
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }

    @Test()
    public void changeSizePhotoTest() {
        String[] serverArgs = new String[]{"--Ice.Config=config.server"};
        String[] customerArgs = new String[]{"--Ice.Config=config.client"};
        List<Pair<MyDevice, Identity>> pairList = PairsGenerator.getListOfPair();
        Server server = new Server(serverArgs, pairList);
        Client client = new Client(customerArgs, pairList);
        try {
            server.start();
            client.start();

            client.command("Camera1", Commands.TURN_ON);
            client.command("Camera1", Commands.SET_PHOTO_SIZE, new PhotoSize[]{new PhotoSize((short)20, (short)30)});
            PhotoSize photoSize = (PhotoSize) client.command("Camera1", Commands.GET_PHOTO_SIZE);

            assertEquals(20, photoSize.x);
            assertEquals(30, photoSize.y);
        }
        finally {
            client.destroyClient();
            server.destroyServer();
        }
    }
}
