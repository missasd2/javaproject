package HIighParallel.chp5.p5.future.jdk_future;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Executors;

/**
 * 使用Futures 工具类将FutureCallback接口注册到给定的Future中，
 * 从而增加了对Future的异常处理。
 */
public class FutureDemo01 {
    public static void main(String[] args) throws InterruptedException {
        // 使用MoreExecutors.listeningDecorator()方法将一个普通的线程池
        // 包装为一个包含通知功能的Future线程池;
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        // 将Callable任务提交到线程池中，并得到一个ListenableFuture;
        //与Future相比，ListenableFuture拥有完成时的通知功能
        ListenableFuture<String> task = service.submit(new RealData("x"));

        Futures.addCallback(task, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println("异步处理成功， result=" + 0);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("异步处理失败，e=" + throwable);
            }
        }, MoreExecutors.newDirectExecutorService());

        System.out.println("main task done.....");
        Thread.sleep(3000);
    }
}
