package HIighParallel.chp3.p1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    // 通过lock生成一个与之绑定的 Condition 对象。
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            // 要求线程在Condition对象上进行等待
            condition.await();
            System.out.println("Thread is going on");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition t1 = new ReenterLockCondition();
        Thread tl = new Thread(t1);
        tl.start();
        Thread.sleep(2000);
        // 通知线程tl继续等待
        lock.lock();
        // 由主线程main发出通知，告知等待在Conditon上的线程可以继续执行了。
        condition.signal();
        lock.unlock();
    }
}
