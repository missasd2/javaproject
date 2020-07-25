package HIighParallel.chp3.p2;

import java.util.concurrent.*;

/**
 * 3.2.4 演示拒绝策略
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " : Thread Id: " + Thread.currentThread().getId());
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            MyTask task = new MyTask();
            // 定义了一个线程池，该线程池有5个常驻线程，且最大线程数量也是5个。，等待队列的容量是10
            ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<Runnable>(10),
                    Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println(r.toString() + " is discard");
                }
            }
            );

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                es.submit(task);
                Thread.sleep(10);
            }
        }
    }
}
