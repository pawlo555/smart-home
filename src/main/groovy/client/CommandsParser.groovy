package client

import pl.edu.agh.Commands

class CommandsParser {

    static parse(String line) {
        line = line.strip()
        def commands = line.split(" ")
        if (isSpecialCommand(commands)) {
            return [commands[0]]
        }
        String device = "Janusz"
        Commands command = Commands.valueOf("TURN_ON")
        def param = getParam('Janusz')
        return [device, command, param]
    }

    static boolean isSpecialCommand(String[] commands) {
        return commands.size() == 1
    }

    def static getParam(String name) {

    }
}
