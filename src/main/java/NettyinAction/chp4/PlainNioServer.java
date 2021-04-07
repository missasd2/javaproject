package NettyinAction.chp4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * 代码清单4-2 未使用Netty的异步网络编程
 */
public class PlainNioServer {
    public void serve(int port) throws IOException {
        ServerSocketChannel serverChnnel = ServerSocketChannel.open();
        serverChnnel.configureBlocking(false);
        ServerSocket ssocket = serverChnnel.socket();
        // 1. 将服务器绑定到选定的端口
        InetSocketAddress address = new InetSocketAddress(port);
        ssocket.bind(address);
        // 2. 打开Selector来处理Channel
        Selector selector = Selector.open();
        // 3. 将ServerSocket 注册到Selector以接受连接
        serverChnnel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi\r\n".getBytes(StandardCharsets.UTF_8));
        for (;;) {
            try {
                // 4. 等待需要处理的新事件；
                // 阻塞将一直持续到下一个传入事件
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            // 5. 获取所有接收事件的SelectionKey实例
            Set<SelectionKey> readKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    // 6. 检查事件是否是一个新的已经就绪可以被接受的连接
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        // 7. 接受客户端，并将它注册到选择器
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate()) ;
                        System.out.println("Accepted connection from " + client);
                    }
                    // 8. 检查套接字是否已经准备好写数据
                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer)key.attachment();
                        while (buffer.hasRemaining()) {
                            // 9. 将数据写到已连接的客户端
                            if (client.write(buffer) == 0) {
                                break;
                            }
                        }
                        // 10. 关闭连接
                        client.close();
                    }
                }catch (IOException e){
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex){

                    }
                }
            }
        }



    }
}
