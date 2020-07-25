package HIighParallel.chp3.p2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 3.2.2
 *  * 2.计划任务 newScheduledThreadPool()
 *      三种方式：
 *          1. schedule()方法会在给定时间，对任务进行一次调度。
 *          2. scheduleAtFixedRate()方法，从上一个任务开始执行时间为起点，在之后的period时间调度下一次任务
 *                                      如果调度周期小于任务的执行时间，那么任务会在上一个任务结束后立即被调用
 *          3. scheduleWithFixedDelay()方法，在上一个任务结束后，再经过delay时间进行任务调度
 *  如果任务遇到异常，那么后续的所有子任务都会停止调度。
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        // 如果前面的任务没有完成，则调度也不会启动
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟线程任务执行耗时
                    Thread.sleep(8000);
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
