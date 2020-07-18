package HIighParallel.chp3.p1;


import java.util.concurrent.locks.LockSupport;

/**
 * 3.1.7 线程阻塞工具类
 *
 *  park() unpark()方法相比于suspend（），resume()方法有优势在于
 *  LockSupport类使用类似信号量的机制。
 *  为每一个线程准备了一个许可，如果许可可用，那么park()方法会立即返回，并且消费这个许可（将许可变为不可用）
 *  如果许可不可用，那么就会阻塞。
 *  unpark()方法使得一个许可变为可用。
 *
 *  特点在于：
 *          即使unpark()操作发生在park()方法之前，它也可以使下一次的park()方法操作立即返回
 */
public class LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in " + getName());
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
