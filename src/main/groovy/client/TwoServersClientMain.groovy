package client

import pl.edu.agh.PairsGenerator

class TwoServersClientMain {

    static void main(String[] args) {
        def clientArgs = ["--Ice.Config=config.client_2"]
        def pairs = PairsGenerator.listOfPairTwoServersFirstServer + PairsGenerator.listOfPairTwoServersSecondServer
        def client = new GroovyClient(clientArgs as String[], pairs)
        client.start()
    }
}
