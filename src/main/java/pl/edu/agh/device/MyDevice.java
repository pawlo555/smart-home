package pl.edu.agh.device;

import SmartHome.Device;
import SmartHome.PowerState;
import com.zeroc.Ice.Current;

public class MyDevice implements Device {
    @Override
    public boolean isTurnedOn(Current current) {
        return false;
    }

    @Override
    public boolean setTo(PowerState state, Current current) {
        return false;
    }

    @Override
    public String getName(Current current) {
        return null;
    }
}
