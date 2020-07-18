package HIighParallel.chp3.p1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 3.1.5 CountDownLatch 倒计数器，实现线程间的计数等待
 */
public class CountDownLatchDemo implements Runnable {
    // 参数表示当前这个计数器的计数个数
    // 表示需要10个线程完成任务后等待在CountDownLatch上的线程才能继续执行。
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try{
            // 模拟检查任务
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check complete");
            // 使用countDown()方法，也就是通知CountDownLatch，一个线程已经完成了任务，倒计数器减1.
            end.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(demo);
        }
        // 等待检查
        // 要求所有主线程等待所有检查任务全部完成，待10个任务全部完成后，主线程才能继续执行。
        end.await();
        // 发射火箭
        System.out.println("Fire !");
        exec.shutdown();
    }
}
