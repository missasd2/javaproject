package NettyinAction.chp8;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.oio.OioDatagramChannel;

import java.net.InetSocketAddress;

public class BootstrapDatagramChannel {
    /**
     * 代码清单 8-8 使用 Bootstrap 和 DatagramChannel
     */
    public void bootstrap() {
        // 创建一个Bootstrap 实例以创建和绑定新的数据报 Channel
        Bootstrap bootstrap = new Bootstrap();
        // 设置 EventLoopGroup，其提供了用以处理 Channel 事件的EventLoop
        bootstrap.group(new OioEventLoopGroup()).channel(
                // 指定 Channel的实现
                OioDatagramChannel.class
        ).handler(
                // 设置用以处理 Channel 的I/O 以及数据的 ChannelInboundHandler
                new SimpleChannelInboundHandler<DatagramPacket>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
                        // Do something with the packet
                    }
                }
        );
        // 调用bind方法，因为该协议是无连接的
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(0));
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("Channel bound");
                } else {
                    System.err.println("Bind attempt failed");
                    future.cause().printStackTrace();
                }
            }
        });
    }
}
