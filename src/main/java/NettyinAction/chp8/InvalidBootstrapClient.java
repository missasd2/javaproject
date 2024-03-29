package NettyinAction.chp8;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.oio.OioSocketChannel;

import java.net.InetSocketAddress;

/**
 * 代码清单8-3 不兼容的 Channel 和 EventLoopGroup
 */
public class InvalidBootstrapClient {

    public static void main(String[] args) {
        // 触发 IllegalStateException
        InvalidBootstrapClient client = new InvalidBootstrapClient();
        client.bootstrap();
    }

    public void bootstrap() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        // 创建一个新的 Bootstrap 类的实例，以创建新的客户端Channel
        Bootstrap bootstrap = new Bootstrap();
        // 指定一个适用于 NIO 的 EventLoopGroup 实现
        bootstrap.group(group)
                // 指定一个适用于 OIO 的 Channel 实现类
        .channel(OioSocketChannel.class)
                // 设置一个用于处理 Channel 的I/O 事件和数据的 ChannelInboundHandler
        .handler(new SimpleChannelInboundHandler<ByteBuf>() {
            @Override
            protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                System.out.println("Received data");
            }
        });
        // 尝试连接到远程节点
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("www.manning.com", 80));
        future.syncUninterruptibly();

    }
}
