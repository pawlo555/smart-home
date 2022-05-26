package pl.edu.agh.device;

import SmartHome.LightBulb;
import com.zeroc.Ice.Current;

public class MyLightBulb extends MyDevice implements LightBulb {
    private boolean lightIfOn = false;

    @Override
    public void turnLightOn(Current current) {
        lightIfOn = true;
    }

    @Override
    public void turnLightOff(Current current) {
        lightIfOn = false;
    }

    @Override
    public boolean isLighting(Current current) {
        return isTurnedOn(current) && lightIfOn;
    }
}
