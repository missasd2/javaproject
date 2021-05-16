package MultiThread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable{
    private String taskName;
    private Date initDate;

    public MyTask(String taskName) {
        this.initDate = new Date();
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.printf("Task: is %s created on %s \n", taskName, initDate);
        System.out.printf("Task: is %s started on %s\n", taskName, new Date());

        // 随机休眠时间，模拟线程执行耗时
        try {
            long duration = (long) Math.random() * 10;
            System.out.printf("Task: %s: Doing a task during %d time", Thread.currentThread().getName(), duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
