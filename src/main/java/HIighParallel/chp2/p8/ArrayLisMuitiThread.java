package HIighParallel.chp2.p8;

import java.util.ArrayList;

/**
 * 2.8.2 并发下的ArrayList
 *  ArrayList的扩容过程中，内部一致性被破坏，
 *  由于没有锁的保护，另一个线程访问到了不一致的状态，导致出现越界
 *
 */
public class ArrayLisMuitiThread {
    static ArrayList<Integer> al = new ArrayList<Integer>(10);
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());
    }
}
