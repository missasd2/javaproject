package HlighParallel.chp5.p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 5.10.1 基于Socket的服务端多线程模式
 */
public class MultiThreadEchoServer {
    // 使用一个线程池来处理每一个客户端连接
    private static ExecutorService tp = Executors.newCachedThreadPool();

    /**
     * 定义一个HandleMsg线程，
     *  由一个客户端Socket构造而成，任务是读取这个Socket的内容并将其返回；
     *  返回成功后，任务完成，客户端Socket就被正常关闭。
     *
     */
    static class HandleMsg implements Runnable{
        Socket clientSocket;
        public HandleMsg(Socket clientSocket){
            this.clientSocket = clientSocket;
        }
        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try{
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(clientSocket.getOutputStream(), true);
                // 从InputStream中读取客户端所发送的数据
                String inputLine = null;
                long b = System.currentTimeMillis();
                while ((inputLine = is.readLine()) != null){
                    os.println(inputLine);
                }
                long e = System.currentTimeMillis();
                // 统计并输出了服务端线程处理一次客户端请求所花费的时间
                System.out.println("spend: " + (e-b) + "ms");
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    if (is != null) is.close();
                    if (os != null) os.close();
                    clientSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 主线程的作用是在8000端口进行等待；一旦有新的客户端连接，
     *  就根据这个连接创建HandleMsg线程进行处理
     * @param args
     */
    public static void main(String[] args) {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        try {
            echoServer = new ServerSocket(8000);
        }catch (IOException e){
            System.out.println(e);
        }
        //根据这个连接创建HandleMsg线程进行处理
        while (true){
            try {
                clientSocket = echoServer.accept();
                System.out.println(clientSocket.getRemoteSocketAddress() + "connect!");
                tp.execute(new HandleMsg(clientSocket));
            }catch (IOException e){
                System.out.println(e);
            }
        }

    }
}
