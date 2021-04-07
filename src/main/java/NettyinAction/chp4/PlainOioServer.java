package NettyinAction.chp4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 代码清单4-1 未使用Netty的阻塞网络编程
 * 阻塞（OIO）版本
 */
public class PlainOioServer {
    public void serve(int port) throws IOException {
        // 1. 将服务器绑定到指定端口
        final ServerSocket socket = new ServerSocket(port);
        try {
            for(;;) {
                // 2. 接受连接
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from "
                + clientSocket);
                // 3. 创建一个新线程来处理该连接
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            // 4. 将消息写给已连接的客户端
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start(); // 5. 启动线程
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
