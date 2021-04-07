package NettyinAction.chp11;

import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.File;
import java.io.FileInputStream;

/**
 * 代码清单11-11 使用 FileRegion 传输文件的内容
 * 仅适用于文件内容的直接传输, 不包括应用程序对数据的任何处理
 */
public class FileRegionWriteHandler extends ChannelInboundHandlerAdapter {

    private static final Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();
    private static final File FILE_FROM_SOMEWHERE = new File("");

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        File file = FILE_FROM_SOMEWHERE;
        Channel channel = CHANNEL_FROM_SOMEWHERE;

        // 创建一个 FileInputStream
        FileInputStream inputStream = new FileInputStream(file);
        // 以该文件的完整长度创建一个新的 DefaultFileRegion
        FileRegion region = new DefaultFileRegion(inputStream.getChannel(), 0, file.length());
        // 发送该 DefaultFileRegion, 并注册一个 ChannelFutureListener
        channel.writeAndFlush(region).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (!future.isSuccess()) {
                    // 处理失败
                    Throwable cause = future.cause();
                }
            }
        });
    }
}
