package HlighParallel.chp6.p6;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * 6.6.2 StampedLock的小陷阱
 */
public class StampedLockCPUDemo {

    static Thread[] holdCpuThreads = new Thread[3];

    static final StampedLock lock = new StampedLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run(){
                // 1 开启线程，占用写锁
                long readLong = lock.writeLock();
                // 2 为了演示效果，使写线程不释放锁而一直等待
                // 线程因为park()函数的操作而进入了等待状态
                LockSupport.parkNanos(60000000000L);
                lock.unlockWrite(readLong);
            }
        }.start();
        Thread.sleep(100);
        // 3 开启3个读线程，让它们请求读锁。由于写锁的存在，
        // 所有读线程都会被最终挂起
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i] = new Thread(new HoldCPUReadThread());
            holdCpuThreads[i].start();
        }
        Thread.sleep(10000);
        // 线程中断后，会占用CPU
        // 线程中断导致park()函数返回，使线程再次进入运行状态；
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i].interrupt();
        }
    }

    private static class HoldCPUReadThread implements Runnable{
        @Override
        public void run(){
            long lockr = lock.readLock();
            System.out.println(Thread.currentThread().getName() + " 获得读锁 ");
            lock.unlockRead(lockr);
        }
    }
}
