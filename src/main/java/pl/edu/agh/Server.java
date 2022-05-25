package pl.edu.agh;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import pl.edu.agh.device.MyDevice;

public class Server {
    public void t1(String[] args)
    {
        int status = 0;
        Communicator communicator = null;

        try	{
            // 1. Inicjalizacja ICE - utworzenie communicatora
            communicator = Util.initialize(args);
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z");

            // 3. Stworzenie serwanta/serwantów
            MyDevice calcServant1 = new MyDevice();

            adapter.add(calcServant1, new Identity("device11", "device"));
            //adapter.add(calcServant2, new Identity("calc22", "calc"));
            //adapter.add(calcServant3, calc33);

            // 5. Aktywacja adaptera i wejście w pętlę przetwarzania żądań
            adapter.activate();

            System.out.println("Entering event processing loop...");

            communicator.waitForShutdown();

        }
        catch (Exception e) {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            }
            catch (Exception e) {
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
    }

    public void start() {

    }

    public static void main(String[] args)
    {
        Server app = new Server();
        app.t1(args);
    }
}
