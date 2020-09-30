package Java7ConcurrencyCookbook.chp3.p2;

import java.util.concurrent.Semaphore;

public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue(){
        // 使用信号量类Semaphore类来实现二进制信号量
        // 二进制信号量，内部计数器只有0和1两个值
        // 非公平模式
        semaphore = new Semaphore(1);
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
