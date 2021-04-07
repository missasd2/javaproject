package NettyinAction.chp7;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExamples {
    private static final Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();

    /**
     * 代码清单7-2 使用 ScheduledExecutorService 调度任务
     */
    public static void schedule() {
        // 创建一个线程池 具有10个线程的 ScheduledExecutorService
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> future = executor.schedule(
                // 创建一个Runnable，以供调度稍后执行
                new Runnable() {
                    @Override
                    public void run() {
                        // 该任务要打印的消息
                        System.out.println("Now it is 60 seconds later");
                    }// 调度任务在执行60秒后，开始执行
                }, 60, TimeUnit.SECONDS
        );
        //..
        // 一旦调度任务执行完成，就关闭 ScheduledExecutorsService 以释放资源
        executor.shutdown();
    }
    /**
     * 代码清单 7-3 使用 EventLoop 调度任务
     */
    public static void scheduledViaEventLoop() {
        Channel ch = CHANNEL_FROM_SOMEWHERE;
        ScheduledFuture<?> future = ch.eventLoop().schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("60 seconds later");
                    }
                }, 60, TimeUnit.SECONDS
        );
    }
    /**
     * 代码清单7-4 使用 EventLoop 调度周期性的任务
     */
    public static void scheduledFixedViaEventLoop() {
        Channel ch = CHANNEL_FROM_SOMEWHERE;
        ch.eventLoop().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // 这将一直运行，直到 ScheduledFuture 被取消
                System.out.println("Run every 60 seconds");
            }
            // 调度在 60秒之后，并且以后每间隔60秒运行
        }, 60, 60, TimeUnit.SECONDS);
    }
    /**
     * 代码清单7-5 使用 ScheduledFuture 取消任务
     */
    public static void cancelingTaskUsingScheduledFuture() {
        Channel ch = CHANNEL_FROM_SOMEWHERE;
        // 调度任务，并获得返回的ScheduledFuture
        ScheduledFuture<?> future = ch.eventLoop().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run every 60 seconds");
            }
        }, 60, 60, TimeUnit.SECONDS);
        //
        boolean mayInterruptIfRunning = false;
        // 取消该任务，防止它再次运行
        future.cancel(mayInterruptIfRunning);
    }
}
