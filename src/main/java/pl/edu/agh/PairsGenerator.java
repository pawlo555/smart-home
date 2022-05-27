package pl.edu.agh;

import com.zeroc.Ice.Identity;
import javafx.util.Pair;
import pl.edu.agh.device.*;

import java.util.Arrays;
import java.util.List;

public class PairsGenerator {

    public static List<Pair<MyDevice, Identity>> getListOfPair() {
        return Arrays.asList(
                new Pair<>(new MyDevice(), new Identity("Device1", "devices")),
                new Pair<>(new MyCamera(), new Identity("Camera1", "cameras")),
                new Pair<>(new MyLightBulb(), new Identity("LightBulb1", "lightbulbs")),
                new Pair<>(new MyLightBulb(), new Identity("LightBulb2", "lightbulbs")),
                new Pair<>(new MyOven(), new Identity("Oven1", "ovens")),
                new Pair<>(new MyMultifunctionalOven(), new Identity("MultifunctionalOven1", "multifunctionalOvens"))
        );
    }

    public static List<Pair<MyDevice, Identity>> getListOfPairTwoServersFirstServer() {
        return Arrays.asList(
                new Pair<>(new MyDevice(), new Identity("Device1", "devices")),
                new Pair<>(new MyCamera(), new Identity("Camera1", "cameras")),
                new Pair<>(new MyOven(), new Identity("Oven1", "ovens")),
                new Pair<>(new MyMultifunctionalOven(), new Identity("MultifunctionalOven1", "multifunctionalOvens"))
        );
    }

    public static List<Pair<MyDevice, Identity>> getListOfPairTwoServersSecondServer() {
        return Arrays.asList(
                new Pair<>(new MyLightBulb(), new Identity("LightBulb1", "lightbulbs")),
                new Pair<>(new MyLightBulb(), new Identity("LightBulb2", "lightbulbs")),
                new Pair<>(new MyLightBulb(), new Identity("LightBulb3", "lightbulbs")),
                new Pair<>(new MyLightBulb(), new Identity("LightBulb4", "lightbulbs"))
       );
    }
}
