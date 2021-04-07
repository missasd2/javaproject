package NettyinAction.chp2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 代码清单 2-2 EchoServer
 *
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.err.println("Usage: " + EchoServer.class.getSimpleName() + " <port> ");
        }
        int port = Integer.parseInt(args[0]); // 设置端口值（如果端口参数不正确，则抛出一个NumberFormatException）
        new EchoServer(port).start(); // 调用服务器的start方法

    }

    public void start() throws InterruptedException {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        // 1. 创建EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            // 2. 创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class) // 3. 指定所使用的 NIO 传输Channel
                    .localAddress(new InetSocketAddress(port)) // 4. 使用指定的接口设置套接字地址
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 5. 添加一个EchoServerHandler到子Channel的ChannelPipeline
                        @Override
                        public void initChannel(SocketChannel ch) {
                            // EchoServerHandler被标注为 @Shareable，所以我们可以总是使用同样的实例
                            ch.pipeline().addLast(serverHandler); //
                        }
                    });
            ChannelFuture f = b.bind().sync(); // 6.异步地绑定服务器；调用sync()方法阻塞等待直到绑定完成
            f.channel().closeFuture().sync(); // 7. 获取 Channel的CloseFuture，并且阻塞当前线程直到它完成

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync(); // 8. 关闭EventLoopGroup，释放所有资源
        }

    }
}
