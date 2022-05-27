package pl.edu.agh.device;

import SmartHome.MultifunctionalOven;
import com.zeroc.Ice.Current;

public class MyMultifunctionalOven extends MyOven implements MultifunctionalOven {

    @Override
    public short getTemperatureInsideOven(Current current) {
        return (short) (getCurrentTemperature(current) - 5);
    }


    @Override
    public short getHumidityInsideOven(Current current) {
        return 50;
    }
}
