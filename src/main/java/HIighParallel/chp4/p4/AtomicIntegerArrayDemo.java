package HIighParallel.chp4.p4;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {
    // 声明了一个包含10个元素的原子整数数组
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);
    // 该线程类型功能：对数组内10个元素进行累加操作
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                arr.getAndIncrement(k%arr.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        // 开启十个累计线程
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10 ; k++) { ts[k].start(); }
        for (int k = 0; k < 10; k++) { ts[k].join(); }
        System.out.println(arr);
    }
}
