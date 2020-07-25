package HIighParallel.chp3.p2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 3.2.2
 * 1. 固定大小的线程池
 * 1595057902934: Thread ID:12
 * 1595057902934: Thread ID:11
 * 1595057902935: Thread ID:13
 * 1595057902935: Thread ID:14
 * 1595057902935: Thread ID:15
 * 1595057903934: Thread ID:11
 * 1595057903934: Thread ID:12
 * 1595057903935: Thread ID:15
 * 1595057903935: Thread ID:14
 * 1595057903935: Thread ID:13
 * 由于线程池数量为5，因此这10个任务分成两批来执行。
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ": Thread ID:"
                + Thread.currentThread().getId()
            );
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        // 定义一个固定线程数量为5的线程池
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // 依次向线程池提交了10个任务。
            es.submit(task);
        }

    }
}
