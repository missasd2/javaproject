package Java7ConcurrencyCookbook.chp1.p6;

import java.util.Date;

/**
 * 线程的休眠使用线程的sleep方法
 */
public class FileDate implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Thread 2 : %s\n", new Date());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
