package pl.edu.agh.device;

import SmartHome.Device;
import SmartHome.PowerState;
import com.zeroc.Ice.Current;

public class MyDevice implements Device {
    private PowerState state = PowerState.OFF;

    @Override
    public boolean isTurnedOn(Current current) {
        System.out.println(state.toString());
        return state == PowerState.ON;
    }

    @Override
    public void setTo(PowerState state, Current current) {
        this.state = state;
    }
}
