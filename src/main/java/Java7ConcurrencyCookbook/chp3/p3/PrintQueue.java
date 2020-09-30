package Java7ConcurrencyCookbook.chp3.p3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class PrintQueue {
    private final Semaphore semaphore;
    // 存放打印机撞他，即空闲或打印
    private boolean[] freePrinters;
    // 用来保护对freePrinter的访问
    private Lock lockPrinters;

    public PrintQueue(){
        // 使用信号量类Semaphore类来实现对同一资源的多个副本的并发访问控制
        // 非公平模式
        semaphore = new Semaphore(3);
    }

    public void printJob(Object document){
        try {
            // 通过acquire()方法获得信号量
            semaphore.acquire();
            long duration = (long)(Math.random() * 10);
            System.out.printf("%s : PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 释放信号量
            semaphore.release();
        }
    }
}
