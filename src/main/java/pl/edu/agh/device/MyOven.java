package pl.edu.agh.device;

import SmartHome.InvalidTemperature;
import SmartHome.InvalidTime;
import SmartHome.Oven;
import SmartHome.Time;
import SmartHome.Modes;
import com.zeroc.Ice.Current;

public class MyOven extends MyDevice implements Oven {
    @Override
    public short getMaxTemperature(Current current) {
        return 0;
    }

    @Override
    public short getMinTemperature(Current current) {
        return 0;
    }

    @Override
    public short getCurrentTemperature(Current current) {
        return 0;
    }

    @Override
    public short setCurrentTemperature(Current current) throws InvalidTemperature {
        return 0;
    }

    @Override
    public Modes[] getSupportedModes(Current current) {
        return new Modes[0];
    }

    @Override
    public void start(Current current) {

    }

    @Override
    public void stop(Current current) {

    }

    @Override
    public void resetTimer(Current current) {

    }

    @Override
    public Time getTime(Current current) {
        return null;
    }


    @Override
    public void setTime(Time time, Current current) throws InvalidTime {

    }

    @Override
    public void isFinish(Current current) {

    }
}
