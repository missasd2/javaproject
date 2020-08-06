package HIighParallel.chp4.p4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger类使用范例
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();
    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                // incrementAndGet()方法会使用CAS自增1，同时也返回当前值；
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        System.out.println(i); // 100000
    }

}
