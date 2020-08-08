package HlighParallel.chp5.p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.rmi.UnexpectedException;

/**
 * 客户端的参考实现
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket client = null;
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            client = new Socket();
            // 连接了服务器的8000端口，并发送字符串；
            client.connect(new InetSocketAddress("localhost", 8000));
            writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Hello ! ");
            writer.flush();

            // 读取服务器的返回信息并进行输出；
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }catch (UnexpectedException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (writer != null){
                writer.close();
            }
            if (reader != null){
                reader.close();
            }
            if (client != null){
                client.close();
            }
        }
    }
}
