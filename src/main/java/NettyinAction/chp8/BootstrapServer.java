package NettyinAction.chp8;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 代码清单8-4 引导服务器
 */
public class BootstrapServer {
    public void bootstrap() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        // 1. 创建 Server Bootstrap
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 2. 设置 EventLoopGroup， 其提供了用于处理Channel 事件的EventLoop
        bootstrap.group(group)
                // 3. 指定要使用的 Channel实现
        .channel(NioServerSocketChannel.class)
                // 4. 设置用于处理已被接受的子 Channel 的I/O及数据的 ChannelInboundHandler
        .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
            @Override
            protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                System.out.println("Received data");
            }
        });
        // 5. 通过配置好的 ServerBootstrap 的实例绑定该 Channel
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()) {
                    System.out.println("Server bound");
                } else {
                    System.out.println("Bind attempt failed");
                    future.cause().printStackTrace();
                }
            }
        });
    }
}
