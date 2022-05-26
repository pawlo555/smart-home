#ifndef _SMART_HOME
#define _SMART_HOME

module SmartHome
{
    enum PowerState { ON, OFF };

    interface Device
    {
        idempotent bool isTurnedOn();
        idempotent void setTo(PowerState state);
    };

    struct Time
    {
        short seconds;
        short minutes;
        short hours;
    };

    exception InvalidTime {
        Time time;
    };

    interface Timer
    {
        idempotent void start();
        idempotent void stop();
        idempotent void resetTimer();
        idempotent Time getTime();
        idempotent void setTime(Time time) throws InvalidTime;
        idempotent bool isFinish();
    };

    enum Modes
    {
        ConventionalOvenCooking,
        FanForced,
        FanForcedGrill,
        Grill,
        TurboGrill,
        Defrost,
        Warmer,
        ECO,
        Pyrolytic,
        PizzaMode,
        FishCooking,
        BreadProving
    };

    sequence<Modes> ModesSequence;

    exception UnsupportedMode
    {
        ModesSequence supportedModes;
        Modes unsupportedMode;
    };

    exception InvalidTemperature
    {
        short minTemperature;
        short maxTemperature;
        short invalidTemperature;
    };

    interface Oven extends Device, Timer
    {
        idempotent short getMaxTemperature();
        idempotent short getMinTemperature();
        idempotent short getCurrentTemperature();
        idempotent void setTemperature(short newTemperature) throws InvalidTemperature;

        idempotent ModesSequence getSupportedModes();
        idempotent Modes getCurrentMode();
        idempotent void setMode(Modes mode) throws UnsupportedMode;
    };

    interface MultifunctionalOven extends Oven
    {
        idempotent short getTemperatureInsideOven();
        idempotent short getHumidityInsideOven();
    };

    interface LightBulb extends Device
    {
        idempotent void turnLightOn();
        idempotent void turnLightOff();
        idempotent bool isLighting();
    };

    struct PhotoSize
    {
        short x;
        short y;
    };

    exception InvalidPhotoSize
    {
        PhotoSize minPhotoSize;
        PhotoSize maxPhotoSize;
        PhotoSize invalidPhotoSize;
    };

    sequence<short> PhotoBytes;

    interface Camera extends Device
    {
        idempotent PhotoSize getPhotoSize();
        idempotent void setPhotoSize(PhotoSize photoSize) throws InvalidPhotoSize;

        idempotent PhotoBytes  getPhoto();
    };
};

#endif