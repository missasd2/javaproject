package Java7ConcurrencyCookbook.chp4.p9;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        while (true){
            System.out.printf("Task: Test %s\n", new Date());
            Thread.sleep(100);
        }
    }


}
