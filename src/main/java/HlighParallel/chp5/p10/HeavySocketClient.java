package HlighParallel.chp5.p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * 定义了一个新的客户端，它会进行10次请求
 * 每一次请求都会访问8000端口。连接成功后，会向服务器输出“Hello!
 */
public class HeavySocketClient {
    // 定义一个线程池
    private static ExecutorService tp = Executors.newCachedThreadPool();
    private static final int sleep_time = 1000*1000*1000;
    public static class EchoClient implements Runnable{

        @Override
        public void run() {
            Socket client = null;
            PrintWriter writer = null;
            BufferedReader reader = null;
            try{
                client = new Socket();
                client.connect(new InetSocketAddress("localhost", 8000));
                writer = new PrintWriter(client.getOutputStream(),true);
                writer.print("H");
                LockSupport.parkNanos(sleep_time);
                writer.println("e");
                LockSupport.parkNanos(sleep_time);
                writer.print("l");
                LockSupport.parkNanos(sleep_time);
                writer.print("l");
                LockSupport.parkNanos(sleep_time);
                writer.print("o");
                LockSupport.parkNanos(sleep_time);
                writer.print("!");
                LockSupport.parkNanos(sleep_time);
                writer.println();
                writer.flush();
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("from server: "+ reader.readLine());
            }catch (UnknownHostException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();

            }finally {
                try {
                   if (writer != null)
                       writer.close();
                   if (reader != null)
                       reader.close();
                   if (client != null)
                       client.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 开启10个线程
        EchoClient ec = new EchoClient();
        for (int i = 0; i < 10; i++) {
            tp.execute(ec);
        }
    }
}
