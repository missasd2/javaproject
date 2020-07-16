package HIighParallel.chp3.p1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 3.1.1 重入锁
 */
public class ReenterLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            // 使用重入锁保护临界区资源i，确保对线程对i操作的安全性
            lock.lock();
            try{
                i++;
            }finally {
                // 重入锁有着显式的操作过程，必须手动指定何时加锁，何时释放锁
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl = new ReenterLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
