package HIighParallel.chp3.p1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 3.1.1 重入锁，提供了中断的能力
 *  如果一个线程正在等待锁，那么它依然可以收到一个通知，被告知无须等待。
 *  这样有助于处理死锁
 */
public class IntLock implements Runnable{

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    /**
     * 控制加锁顺序，方便构造死锁
     */
    public IntLock(int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            if (lock == 1){
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){

                }
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
            }
            lock1.lockInterruptibly();
        }
    }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread())
                lock1.unlock();
            if (lock2.isHeldByCurrentThread())
                lock2.unlock();
            System.out.println(Thread.currentThread().getId() + " : 线程退出");
        }
        }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(1);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        // 中断其中一个线程
        t2.interrupt();
    }
}

