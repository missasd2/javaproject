package CoreVolumeTow.chp3.threaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer {

    public static void main(String[] args) {
        try {
            int i = 1;
            ServerSocket s = new ServerSocket(8189);
            while (true){
                // 每当程序建立一个新的套接字连接，
                // 也就是说当调用accept时
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                // 将启动一个新的线程来处理服务器和该客户端之间的连接，
                ThreadedEchoHandler r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
                // 而主程序将立即返回并等待下一个连接
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
