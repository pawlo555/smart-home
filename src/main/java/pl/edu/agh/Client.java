package pl.edu.agh;

import SmartHome.*;

import com.zeroc.Ice.*;
import javafx.util.Pair;
import pl.edu.agh.device.MyDevice;

import java.lang.Exception;
import java.util.List;

public class Client
{

    public Client(String[] args, List<Pair<MyDevice, Identity>> servantsIdentityPair) {

    }

    public static void main(String[] args)
    {
        int status = 0;
        Communicator communicator = null;

        try {
            // 1. Inicjalizacja ICE
            communicator = Util.initialize(args);

            // 2. Uzyskanie referencji obiektu na podstawie linii w pliku konfiguracyjnym (wówczas aplikację należy uruchomić z argumentem --Ice.config=config.client)
            //ObjectPrx base1 = communicator.propertyToProxy("Calc1.Proxy");

            // 2. To samo co powyżej, ale mniej ładnie
            ObjectPrx base1 = communicator.stringToProxy("device/device11:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z"); //opcja -z włąza **możliwość** kompresji

            // 3. Rzutowanie, zawężanie (do typu Calc)
            DevicePrx obj1 = DevicePrx.checkedCast(base1);
            if (obj1 == null) throw new Error("Invalid proxy");


            boolean turned = obj1.isTurnedOn();
            System.out.println(turned);


        } catch (LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (communicator != null) { //clean
            try {
                communicator.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }

    public boolean command() {
        return false;
    }
}
