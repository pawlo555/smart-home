package pl.edu.agh;

public class ServersMain {

    public static void main(String[] args) {
        String[] firstServerArgs = new String[]{"--Ice.Config=config.server"};
        String[] secondServerArgs = new String[]{"--Ice.Config=config.server_2"};
        Server firstServer = new Server(firstServerArgs, PairsGenerator.getListOfPairTwoServersFirstServer());
        Server secondServer = new Server(secondServerArgs, PairsGenerator.getListOfPairTwoServersSecondServer());
        try {
            firstServer.start();
            secondServer.start();
            firstServer.work();
        }
        finally {
            secondServer.destroyServer();
            firstServer.destroyServer();
        }
    }
}
