package Java7ConcurrencyCookbook.chp4.p3;

import Java7ConcurrencyCookbook.chp4.p2.Task;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    // 声明一个名为executor的ThreadPoolExecutor属性
    private ThreadPoolExecutor executor;

    public Server() {
        // 通过使用Executors工厂类的 newFixedThreadPool()方法创建了一个固定大小地线程池；
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");
        // 对于执行器executor来说，可以使用execute()方法来发送Runnable或Callable类型的任务给执行器；
        executor.execute(task);
        // 返回线程池中实际的线程数
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        // 返回执行器中正在执行任务的线程数
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        // 返回已发送到执行器上的任务数
        System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
        // 返回执行器已经完成的任务数
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());

    }

    public void endServer(){
        // 执行其以及ThreadPoolExecutor类需要显式地结束它；
        executor.shutdown();
    }
}
