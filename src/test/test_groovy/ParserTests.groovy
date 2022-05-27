package test_groovy

import SmartHome.Modes
import SmartHome.Time
import client.CommandsParser
import org.junit.Test
import pl.edu.agh.Commands
import SmartHome.PhotoSize


import static org.junit.Assert.assertEquals

class ParserTests {

    @Test
    void deviceCommandTest() {
        def output = CommandsParser.parse("DEVICES  ")
        assertEquals(["DEVICES"], output)
    }

    @Test
    void commandsCommandTest() {
        def output = CommandsParser.parse(" COMMANDS  ")
        assertEquals(["COMMANDS"], output)
    }

    @Test
    void exitCommandsTest() {
        def output = CommandsParser.parse(" EXIT")
        assertEquals(["EXIT"], output)
    }

    @Test
    void turnOnTest() {
        def output = CommandsParser.parse("Device1 TURN_ON")
        assertEquals(["Device1", Commands.TURN_ON], output)
    }

    @Test
    void turnOffTest() {
        def output = CommandsParser.parse("LightBulb1 TURN_OFF ")
        assertEquals(["LightBulb1", Commands.TURN_OFF], output)
    }

    @Test
    void checkPowerTest() {
        def output = CommandsParser.parse("LightBulb1 CHECK_POWER ")
        assertEquals(["LightBulb1", Commands.CHECK_POWER], output)
    }

    @Test
    void checkGetHumidityTest() {
        def output = CommandsParser.parse("MultiFunctionalOven1 GET_HUMIDITY ")
        assertEquals(["MultiFunctionalOven1", Commands.GET_HUMIDITY], output)
    }

    @Test(expected = IllegalArgumentException.class)
    void checkInvalidCommandTest() {
        CommandsParser.parse("SomeDevice INVALID_COMMAND")
    }

    @Test()
    void checkSetModeParseTest() {
        def output = CommandsParser.parse("MultiFunctionalOven1 SET_MODE ECO")
        assertEquals(["MultiFunctionalOven1", Commands.SET_MODE, Modes.ECO], output)
    }

    @Test(expected = IllegalArgumentException.class)
    void checkInvalidSetModeParseTest() {
        CommandsParser.parse("MultiFunctionalOven1 SET_MODE ECO2.0")
    }

    @Test()
    void checkSetPhotoSizeParseTest() {
        def output = CommandsParser.parse("MultiFunctionalOven1 SET_PHOTO_SIZE 10:20")
        assertEquals(["MultiFunctionalOven1", Commands.SET_PHOTO_SIZE, new PhotoSize(10 as short, 20 as short)], output)
    }

    @Test(expected = IllegalArgumentException.class)
    void checkInvalidSetPhotoSizeParseTest() {
        CommandsParser.parse("Camera SET_PHOTO_SIZE 134")
    }

    @Test(expected = IllegalArgumentException.class)
    void checkInvalidStringSetPhotoSizeParseTest() {
        CommandsParser.parse("Camera SET_PHOTO_SIZE cos:cos")
    }

    @Test()
    void checkSetTemperatureParseTest() {
        def output = CommandsParser.parse("Oven1 SET_TEMPERATURE 213")
        assertEquals(["Oven1", Commands.SET_TEMPERATURE, 213 as short], output)
    }

    @Test(expected = IllegalArgumentException.class)
    void checkInvalidSetTemperatureParseTest() {
        CommandsParser.parse("Oven1 SET_TEMPERATURE hundred")
    }

    @Test()
    void checkTimeParseTest() {
        def output = CommandsParser.parse("Oven1 SET_TIME 4:23:30")
        assertEquals(["Oven1", Commands.SET_TIME, new Time(30 as short, 23 as short, 4 as short)], output)
    }

    @Test(expected = IllegalArgumentException.class)
    void checkInvalidTimeParseTest() {
        CommandsParser.parse("Oven1 SET_TIME ref:23:30")
    }

    @Test(expected = IllegalArgumentException.class)
    void checkInvalidStringTimeParseTest() {
        CommandsParser.parse("Oven1 SET_TIME oneHour")
    }

    @Test(expected = IllegalArgumentException.class)
    void fourStringParseTest() {
        CommandsParser.parse("Oven1 SET_TIME oneHour dwa")
    }
}
