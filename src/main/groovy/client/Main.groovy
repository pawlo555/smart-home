package client

import pl.edu.agh.PairsGenerator
import pl.edu.agh.Server
import client.GroovyClient

class Main {

    static void main(String[] args) {
        def clientArgs = ["--Ice.Config=config.client"]
        def pairs = PairsGenerator.listOfPair
        def client = new GroovyClient(clientArgs as String[], pairs)
        client.start()
    }
}
