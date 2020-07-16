package HIighParallel.chp3.p1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 避免死锁的方法：
 *  等待外部通知：例如中断
 *  限时等待：若线程等待的时间超过了指定值则放弃申请锁
 */
public class TimeLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            // tryLock方法指定等待的时长为5秒，表示线程在这个锁最多等待5秒，
            // 若没有得到则返回false
            if (lock.tryLock(5, TimeUnit.SECONDS)){
                Thread.sleep(6000);
            }else {
                System.out.println("get lock failed");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        TimeLock tl = new TimeLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
    }
}
