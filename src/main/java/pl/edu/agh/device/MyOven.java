package pl.edu.agh.device;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.Arrays;

public class MyOven extends MyDevice implements Oven {
    public final static short MAX_TEMPERATURE = 230;
    public final static short MIN_TEMPERATURE = 20;

    private short currentTemperature = MIN_TEMPERATURE;

    private final Modes[] supportedModes = new Modes[] {Modes.ConventionalOvenCooking, Modes.Grill, Modes.Warmer,
            Modes.ECO, Modes.Defrost };
    private Modes currentMode = supportedModes[0];

    private long timeMillis = 0;
    private int timeSet = 0;
    private boolean timeWorking = false;

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

    @Override
    public void start(Current current) {
        if (isTurnedOn(current)) {
            timeWorking = true;
        }
    }

    @Override
    public void stop(Current current) {
        if (isTurnedOn(current)) {
            updateTime();
            timeWorking = false;
        }
    }

    @Override
    public void resetTimer(Current current) {
        if (isTurnedOn(current)) {
            timeWorking = false;
            timeSet = 0;
        }
    }

    @Override
    public Time getTime(Current current) {
        if (isTurnedOn(current)) {
            updateTime();
        }
        return new Time((short)(timeSet%60), (short)((timeSet/60)%60), (short)(timeSet/3600));
    }

    @Override
    public void setTime(Time time, Current current) throws InvalidTime {
        if(!timeIsValid(time)) {
            throw new InvalidTime(time);
        }
        if (isTurnedOn(current)) {
            updateTime();
            timeSet = time.hours * 3600 + time.minutes * 60 + time.seconds;
        }
    }

    private boolean timeIsValid(Time time) {
        return time.seconds >= 0 && time.minutes >= 0 && time.hours >=0 && time.seconds < 60 && time.minutes < 60;
    }

    @Override
    public boolean isFinish(Current current) {
        if (isTurnedOn(current)) {
            updateTime();
            return timeSet == 0;
        }
        return false;
    }

    private void updateTime() {
        if (timeWorking) {
            long timeMillis = System.currentTimeMillis();
            int timeDiff = (int) (timeMillis - this.timeMillis);
            this.timeMillis = timeMillis;
            timeSet = Math.max(0, timeSet - timeDiff);
        }
    }
}
