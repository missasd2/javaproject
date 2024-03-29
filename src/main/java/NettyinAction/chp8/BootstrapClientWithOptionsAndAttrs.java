package NettyinAction.chp8;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;

/**
 * 代码清单8-7 使用属性值
 */
public class BootstrapClientWithOptionsAndAttrs {
    public void bootstrap() {
        // 创建一个 AttributeKey 以标识该属性
        final AttributeKey<Integer> id = AttributeKey.newInstance("ID");
        // 创建一个 Bootstrap 类的实例以创建客户端 Channel 并连接它们
        Bootstrap bootstrap = new Bootstrap();
        // 设置 EventLoopGroup， 其提供了用以处理Channel 事件的EventLoop
        bootstrap.group(new NioEventLoopGroup())
                // 指定 Channel 的实现
        .channel(NioSocketChannel.class)
                .handler(
                        // 设置用以处理Channel 的I/O 以及数据的ChannelInboundHandlerAdapter
                        new SimpleChannelInboundHandler<ByteBuf>() {
                            @Override
                            public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
                                // 使用 AttributeKey 检索属性以及它的值
                                Integer idValue = ctx.channel().attr(id).get();
                            }

                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                                System.out.println("Received data");
                            }
                        }
                );
        // 设置 ChannelOption，其将在 connect()或者bind（）方法被调用时被设置
        // 到已经创建的 Channel上
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        // 存储该id属性
        bootstrap.attr(id, 123456);
        // 使用配置好的 Bootstrap 实例连接到远程主机
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("www.manning.com", 80));
        future.syncUninterruptibly();
    }
}
