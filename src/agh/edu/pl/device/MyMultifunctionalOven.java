package agh.edu.pl.device;

import SmartHome.MultifunctionalOven;
import com.zeroc.Ice.Current;

public class MyMultifunctionalOven extends MyOven implements MultifunctionalOven {
    @Override
    public short getTemperatureInsideOven(Current current) {
        return 0;
    }

    @Override
    public short getHumidityInsideOven(Current current) {
        return 0;
    }
}
