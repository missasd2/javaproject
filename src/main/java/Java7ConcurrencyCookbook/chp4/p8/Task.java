package Java7ConcurrencyCookbook.chp4.p8;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Runnable {

    private String name;
    public Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting at : %s \n", name, new Date());

    }
}
