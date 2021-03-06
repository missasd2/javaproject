package HIighParallel.chp3.p1;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 3.1.4 读写锁
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock(); // 模拟读操作
            Thread.sleep(1000); // 读操作的耗时越多，读写锁的优势就越明显
            return value;
        }finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException{
        try {
            lock.lock();// 模拟写操作
            Thread.sleep(1000);
            value=index;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable(){
            @Override
            public void run() {
                try {
                    // 使用读锁
                    demo.handleRead(readLock);
                    // 使用写锁
                            demo.handleRead(lock);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Runnable writeRunnable = new Runnable(){
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock, new Random().nextInt());
                    demo.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 开启18个读线程
        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }
        // 开启2个写线程
        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnable).start();
        }
        // 读线程完全并行，写会阻塞读，
    }
}
