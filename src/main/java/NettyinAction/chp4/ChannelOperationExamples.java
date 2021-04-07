package NettyinAction.chp4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 代码清单4-5 写出到Channel
 *
 */
public class ChannelOperationExamples {
    private static final Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();
    /*
    代码清单4-5 写出到 Channel
     */
    public static void writingToChannel() {
        Channel channel = CHANNEL_FROM_SOMEWHERE;
        //1. 创建持有要写数据的ByteBuf
        ByteBuf buf = Unpooled.copiedBuffer("your data", CharsetUtil.UTF_8);
        // 2. 写数据并冲刷它
        ChannelFuture cf = channel.writeAndFlush(buf);
        // 3. 添加ChannelFutureListener以便在写操作完成后接收通知
        cf.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                // 4. 写操作完成，并且没有错误发生
                if (future.isSuccess()) {
                    System.out.println("Write successful");
                } else {
                    System.err.println("Write error");
                    // 5. 记录错误
                    future.cause().printStackTrace();
                }
            }
        });
    }

    /**
     *   代码清单4-6 从多个线程使用同一个Channel
     */
    public static void writingToChannelFromManyThreads() {
        // Netty的 Channel 实现是线程安全的，因此你可以存储一个到Channel的引用，
        // 并且每当需要向远程节点写数据时，都可以使用它。
        final Channel channel = CHANNEL_FROM_SOMEWHERE;
        // 1. 创建持有要写数据的ByteBuf
        final ByteBuf buf = Unpooled.copiedBuffer("your data", CharsetUtil.UTF_8);
        // 2. 创建将数据写到 Channel 的 Runnable
        Runnable writer = new Runnable() {
            @Override
            public void run() {
                channel.writeAndFlush(buf.duplicate());
            }
        };
        // 3. 获取到线程池Executor 的引用
        Executor executor = Executors.newCachedThreadPool();
        // 4. 递交写任务给线程池以便在某个线程种执行
        executor.execute(writer);
        // 5. 递交另一个写任务以便在另一个线程种执行
        executor.execute(writer);
    }


}
