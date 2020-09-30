package Java7ConcurrencyCookbook.chp2.p7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印队列类 公平锁
 */
public class PrintQueue {
    // 公平锁
    private final Lock queueLock = new ReentrantLock(true);
    //
    public void printJob(Object document){
        queueLock.lock();
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":  first lock PrintQueue: Printing a Job during "+ (duration/1000)+" seconds");
            Thread.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }

        queueLock.lock();
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": second lock PrintQueue: Printing a Job during "+ (duration/1000)+" seconds");
            Thread.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }

    }
}
