package pl.edu.agh.device;

import SmartHome.MultifunctionalOven;
import com.zeroc.Ice.Current;

public class MyMultifunctionalOven extends MyOven implements MultifunctionalOven {
    // TODO
    @Override
    public short getTemperatureInsideOven(Current current) {
        return (short) (getCurrentTemperature(current) - 5);
    }

    // TODO
    @Override
    public short getHumidityInsideOven(Current current) {
        return 50;
    }
}
