package Java7ConcurrencyCookbook.chp1.p7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable{

    @Override
    public void run() {
        System.out.printf("Beginning network connections: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network Connecting has been finished: %s\n ", new Date());
    }
}
