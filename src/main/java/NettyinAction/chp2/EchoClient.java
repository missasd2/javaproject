package NettyinAction.chp2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;


/**
 * 代码清单 2-4 客户端的主类
 */
public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup(); //
        try {
            Bootstrap b = new Bootstrap(); // 1. 创建Bootstrap
            b.group(group) // 指定 EventLoopGroup 以处理客户端时间；需要适用于NIO的实现
                    .channel(NioServerSocketChannel.class) // 适用于NIO 传输的 Channel类型
                    .remoteAddress(new InetSocketAddress(host, port))
                    // 在创建 Channel时，向ChannelPipeline 中添加一个 EchoClientHandler 实例
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture f = b.connect().sync();  // 连接到远程节点，阻塞等待直到 连接完成
            f.channel().closeFuture().sync();  // 阻塞，直到Channel关闭
        } finally {
            group.shutdownGracefully().sync();  // 关闭线程池并且释放所有的资源
        }
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.err.println("Usage: " + EchoClient.class.getSimpleName() + " <host> <port> ");
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        new EchoClient(host, port).start();
    }
}
