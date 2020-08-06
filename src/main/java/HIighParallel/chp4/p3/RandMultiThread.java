package HIighParallel.chp4.p3;

import java.util.Random;
import java.util.concurrent.*;

public class RandMultiThread {
    // 定义了每个线程要产生随机数数量
    public static final int GEN_COUNT = 10000000;
    // 定义了参与工作的线程数量
    public static final int THREAD_COUNT = 4;
    // 定义了线程池
    static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);
    // 定义：被多线程共享的Random实例，用于产生随机数
    public static Random rnd = new Random(123);
    // 定义了由ThreadLocal封装的Random
    public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>(){
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    // 定义工作线程的内部逻辑，有两种模式
    // 第一种模式：多线程共享一个Random(mode=0)
    // 第二种模式：多个线程各分配一个Random(mode=1)

    public static class RndTask implements Callable<Long>{
        private int mode = 0;

        public RndTask(int mode){
            this.mode = mode;
        }

        public Random getRandom(){
            if (mode == 0){
                return rnd;
            }else if (mode == 1){
                return tRnd.get();
            }else {
                return null;
            }
        }
        // 定义了线程的工作内容；每个线程都会产生若干个随机数，完成工作后记录所消耗的时间
        @Override
        public Long call() throws Exception {
            long b = System.currentTimeMillis();
            for (long i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "Spend " + (e-b) + " ms");
            return e - b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] futs = new Future[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = exe.submit(new RndTask(0));
        }
        long totaltime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totaltime += futs[i].get();
        }
        System.out.println("多线程访问同一个Random实例:" + totaltime + "ms");

        // ThreadLocal的情况
        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = exe.submit(new RndTask(1));
        }
        totaltime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totaltime += futs[i].get();
        }
        System.out.println("使用ThreadLocal包装Random实例:" + totaltime + "ms");
        exe.shutdown();
    }
}
