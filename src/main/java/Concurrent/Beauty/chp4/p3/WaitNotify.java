package Concurrent.Beauty.chp4.p3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();


    static class Waits implements Runnable{
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock){
                // 当条件不满足时，继续wait，同时释放了lock的锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread() + "flagistrue.wait @ "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread() + " flag is false. running @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }


    static class Notifys implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁
                // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + "hold lock. notify @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);

            }

            // 再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock again. sleep @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);

            }
            // 经过再次加锁，释放锁后WaitThread才能从wait方法中返回
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Waits(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notifys(), "NotifyThread");
        notifyThread.start();
    }

}


