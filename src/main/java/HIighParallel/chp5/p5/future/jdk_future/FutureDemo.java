package HIighParallel.chp5.p5.future.jdk_future;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;

public class FutureDemo {
    public static void main(String[] args) throws InterruptedException {
        // 使用MoreExecutors.listeningDecorator()方法将一个普通的线程池
        // 包装为一个包含通知功能的Future线程池;
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        // 将Callable任务提交到线程池中，并得到一个ListenableFuture;
        //与Future相比，ListenableFuture拥有完成时的通知功能
        ListenableFuture<String> task = service.submit(new RealData("x"));

        task.addListener(() -> {
            System.out.println("异步处理成功：");
            try {
                System.out.println(task.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }, MoreExecutors.directExecutor()
        );

        System.out.println("main task done.....");
        Thread.sleep(3000);
    }
}
