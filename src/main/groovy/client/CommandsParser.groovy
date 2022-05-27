package client

import SmartHome.Modes
import SmartHome.PhotoSize
import SmartHome.Time
import pl.edu.agh.Commands

class CommandsParser {

    static parse(String line) {
        line = line.strip()
        def commands = line.split(" ")
        if (commands.size() == 1) {
            return [commands[0]]
        }
        else {
            if (commands.size() > 3) {
                throw new IllegalArgumentException("Too many arguments in: ${line}")
            }
            String device = commands[0]
            Commands command = Commands.valueOf(commands[1])
            if (commands.size() == 3) {
                def param = getParam(commands[2], command)
                return [device, command, param]
            }
            return [device, command ]
        }
    }

    def static getParam(String name, Commands command) {
        switch(command) {
            case Commands.SET_MODE:
                return parseMode(name)
            case Commands.SET_PHOTO_SIZE:
                return parsePhotoSize(name)
            case Commands.SET_TEMPERATURE:
                return parseTemperature(name)
            case Commands.SET_TIME:
                return parseTime(name)
        }
    }

    def static parseMode(String name) {
        try {
            return Modes.valueOf(name)
        }
        catch (Exception ignored) {
            throw new IllegalArgumentException("Invalid oven mode - available modes:\n ${Modes.values()}")
        }
    }

    def static parsePhotoSize(String size) {
        try {
            def list = size.split(":")
            short x = Short.parseShort(list[0])
            short y = Short.parseShort(list[1])
            return new PhotoSize(x,y)
        }
        catch (Exception ignored) {
            throw new IllegalArgumentException("Invalid photoSize: ${size} - format is: x:y")
        }
    }

    def static parseTemperature(String temp) {
        try {
            return Short.parseShort(temp)
        }
        catch (Exception ignored) {
            throw new IllegalArgumentException("Invalid temperature: ${temp} - format is: x")
        }
    }

    def static parseTime(String timeName) {
        try {
            def list = timeName.split(":")
            short seconds = Short.parseShort(list[2])
            short minutes = Short.parseShort(list[1])
            short hours = Short.parseShort(list[0])
            return new Time(seconds, minutes, hours)
        }
        catch (Exception ignored) {
            throw new IllegalArgumentException("Invalid time: ${timeName} - format is: hours:minutes:seconds}")
        }
    }
}
