package test_groovy

import client.CommandsParser
import org.junit.Test
import pl.edu.agh.Commands

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
        assertEquals(["Device1", Commands.TURN_ON, null], output)
    }

    @Test
    void turnOffTest() {
        def output = CommandsParser.parse("LightBulb1 TURN_OFF ")
        assertEquals(["LightBulb1", Commands.TURN_OFF, null], output)
    }

    @Test
    void checkPowerTest() {
        def output = CommandsParser.parse("LightBulb1 CHECK_POWER ")
        assertEquals(["LightBulb1", Commands.CHECK_POWER, null], output)
    }
}
