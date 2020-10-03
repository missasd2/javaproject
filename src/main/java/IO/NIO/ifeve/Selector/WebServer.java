package IO.NIO.ifeve.Selector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * # https://www.cnblogs.com/snailclimb/p/9086334.html
 */
public class WebServer {
    public static void main(String[] args) {
        try {
            // 初始化ServerSocketChannel
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("localhost", 8000));
            ssc.configureBlocking(false); // 与Slector一起使用时，Channel必须处于非阻塞模式下

            // 创建一个Selector
            Selector selector = Selector.open();

            // 向Selector注册Channel,第二个参数表示Selector监听哪种事件
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            // Buffer初始化
            ByteBuffer readBuff = ByteBuffer.allocate(1024);
            ByteBuffer writeBuff = ByteBuffer.allocate(128);
            writeBuff.put("received".getBytes());
            writeBuff.flip();

            while (true){
                int nReady = selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove();

                    if (key.isAcceptable()){
                        // 创建新的连接，并且把连接注册到selector上，而且
                        // 声明这个channel值对读操作感兴趣
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    else if (key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel)key.channel();
                        readBuff.clear();
                        socketChannel.read(readBuff);

                        readBuff.flip();
                        System.out.println("received : " + new String(readBuff.array()));
                        key.interestOps(SelectionKey.OP_WRITE);
                    }
                    else if (key.isWritable()){
                        writeBuff.rewind();
                        SocketChannel socketChannel = (SocketChannel)key.channel();
                        socketChannel.write(writeBuff);
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
