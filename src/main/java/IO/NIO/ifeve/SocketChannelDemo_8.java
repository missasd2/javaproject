package IO.NIO.ifeve;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo_8 {

    public static void demo1() throws IOException {

        /**
         *  创建SocketChannel
         */
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("www.baidu.com", 80));

        // 2. 连接校验


        /**
         * 创建缓冲区
         */
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(buf);

        /**
         * 循环从缓冲区读取数据
         */
        while (bytesRead != -1){
            System.out.println("Read " + bytesRead);
            // Buffer转换到读模式
            buf.flip();

            while (buf.hasRemaining()){
                System.out.println((char) buf.get());
            }

            buf.clear();
            socketChannel.read(buf);

        }
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        demo1();
    }
}
