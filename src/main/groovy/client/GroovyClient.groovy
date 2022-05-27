package client

import com.zeroc.Ice.Identity
import javafx.util.Pair
import pl.edu.agh.Commands
import pl.edu.agh.device.MyDevice


class GroovyClient {

    ClientConnection connection

    GroovyClient(String[] args, List<Pair<MyDevice, Identity>> proxies) {
        connection = new ClientConnection(args, proxies)
    }

    def start() {
        connection.start()
        println "Welcome in SmartHome"
        println "List of devices type: DEVICES"
        println "List of commands type: COMMANDS"
        println "Type EXIT to exit"
        println "To pass command to device type:"
        println "<device name> <command name> <param>"
        Scanner scanner = new Scanner(System.in)
        do {
            String line = scanner.nextLine()
            def list = CommandsParser.parse(line)
            performOperation(list)
        }
        while (true)
    }

    def performOperation(List args) {
        if (args.size() == 1) {
            performSpecialOperation(args[0] as String)
        }
    }

    def performSpecialOperation(String command) {
        switch (command) {
            case "DEVICES":
                showDevices()
                break
            case "COMMANDS":
                showCommands()
                break
            case "EXIT":
                exit()
        }
    }

    def showDevices() {
        println "Available devices:"
        for (deviceName in connection.getDevices()) {
            println deviceName
        }
    }

    def static showCommands() {
        println "Available commands:"
        for (commandName in Commands.values()) {
            println commandName
        }
    }

    def exit() {
        connection.destroyClient()
        System.exit(0)
    }
}
