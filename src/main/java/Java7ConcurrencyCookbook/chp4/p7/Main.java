package Java7ConcurrencyCookbook.chp4.p7;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // 通过Executors工厂类来创建ScheduledThreadPoolExecutor
        // newScheduledThreadPool()方法的参数伪线程池里拥有的线程数
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new Date());
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task: " + i);
            // schedule()方法 中的delay参数表示要等待的时间，第三个参数为时间的单位
            executor.schedule(task, i+1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        // 调用执行器的 awaitTermination()方法等待所有任务结束
        try {
            // awaitTermination方法等待所有任务结束
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Ends at: %s \n", new Date());
    }
}
