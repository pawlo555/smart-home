package pl.edu.agh.device;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.Arrays;

public class MyOven extends MyDevice implements Oven {
    public final static short MAX_TEMPERATURE = 230;
    public final static short MIN_TEMPERATURE = 20;

    private short currentTemperature = MIN_TEMPERATURE;

    private final Modes[] supportedModes = new Modes[] {Modes.ConventionalOvenCooking, Modes.Grill, Modes.Warmer, Modes.ECO,
            Modes.Defrost };
    private Modes currentMode = supportedModes[0];

    @Override
    public short getMaxTemperature(Current current) {
        return MAX_TEMPERATURE;
    }

    @Override
    public short getMinTemperature(Current current) {
        return MIN_TEMPERATURE;
    }

    @Override
    public short getCurrentTemperature(Current current) {
        return currentTemperature;
    }

    @Override
    public void setTemperature(short newTemperature, Current current) throws InvalidTemperature {
        if (isValidTemperature(newTemperature)) {
            currentTemperature = newTemperature;
        }
        else {
            throw new InvalidTemperature(MIN_TEMPERATURE, MAX_TEMPERATURE, newTemperature);
        }
    }

    private boolean isValidTemperature(short newTemperature) {
        return newTemperature > MIN_TEMPERATURE && newTemperature < MAX_TEMPERATURE;
    }

    @Override
    public Modes[] getSupportedModes(Current current) {
        return supportedModes;
    }

    @Override
    public Modes getCurrentMode(Current current) {
        return currentMode;
    }

    @Override
    public void setMode(Modes mode, Current current) throws UnsupportedMode {
        if (isModeSupported(mode)) {
            currentMode = mode;
        }
        else {
            throw new UnsupportedMode(supportedModes, mode);
        }
    }

    private boolean isModeSupported(Modes mode) {
        return Arrays.stream(supportedModes).anyMatch(modes1 -> modes1 == mode);
    }

    // TODO
    @Override
    public void start(Current current) {

    }

    // TODO
    @Override
    public void stop(Current current) {

    }

    // TODO
    @Override
    public void resetTimer(Current current) {

    }

    // TODO
    @Override
    public Time getTime(Current current) {
        return null;
    }

    // TODO
    @Override
    public void setTime(Time time, Current current) throws InvalidTime {

    }

    // TODO
    @Override
    public void isFinish(Current current) {

    }
}
