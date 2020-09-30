package Java7ConcurrencyCookbook.chp4.p12;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        // 创建对象来管理被拒绝的任务
        RejectedTaskController controller = new RejectedTaskController();

        // 调用Executors工厂类的newCachedThreadPool()方法创建ThreadPoolExecutor执行器对象
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        // 设置用于被拒绝的任务的处理程序
        executor.setRejectedExecutionHandler(controller);

        // 创建3个任务并发送给执行器
        System.out.printf("Main: Starting. \n");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task " + i);
            executor.submit(task);
        }

        System.out.printf("Main: Shutting down the Executor. \n");
        executor.shutdown();

        //
        System.out.printf("Main: Sending another Task. \n");
        Task rejectedTask = new Task("RejectedTask");
        executor.submit(rejectedTask);

        System.out.printf("Main: End");
        System.out.println("Main: End. \n");
    }
}
