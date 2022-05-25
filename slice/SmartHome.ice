#ifndef _SMART_HOME
#define _SMART_HOME

module SmartHome
{
    enum PowerState { ON, OFF };

    interface Device
    {
        idempotent bool isTurnedOn();
        idempotent bool setTo(PowerState state);

        idempotent string getName();
    };

    struct Time
    {
        short seconds;
        short minutes;
        short hours;
    };

    exception InvalidTime {};

    interface Timer
    {
        idempotent void start();
        idempotent void stop();
        idempotent void resetTimer();
        idempotent Time getTime();
        idempotent void setTime(Time time) throws InvalidTime;
        idempotent void isFinish();
    };


    enum Modes { LOW, DEFROST, MED, MEDIUMHEIGH, HIGH };

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
        idempotent short setCurrentTemperature() throws InvalidTemperature;

        idempotent ModesSequence getSupportedModes();
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
        idempotent void setPhotoSize(PhotoSize photoSize);

        idempotent PhotoBytes  getPhoto();
    };
};

#endif