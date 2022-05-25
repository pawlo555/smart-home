package agh.edu.pl.device;

import SmartHome.LightBulb;
import com.zeroc.Ice.Current;

public class MyLightBulb extends MyDevice implements LightBulb {
    @Override
    public void turnLightOn(Current current) {

    }

    @Override
    public void turnLightOff(Current current) {

    }

    @Override
    public boolean isLighting(Current current) {
        return false;
    }
}
