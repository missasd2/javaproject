package Java7ConcurrencyCookbook.chp4.p9;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.printf("Main: Executing the Task \n");
        // 执行器的submit方法返回名为result的Future对象
        Future<String> result = executor.submit(task);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Canceling the Task \n");
        // 调用Future对象的cancel()方法来取消任务的执行
        result.cancel(true);
        System.out.printf("Main: Cancelled: %s \n", result.isCancelled());
        System.out.printf("Main: Done: %s\n", result.isDone());
        executor.shutdown();
        System.out.printf("Main: The executor has finished\n");
    }
}
