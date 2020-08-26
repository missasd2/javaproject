package CoreVolumeTow.chp3.Socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);

            // 构建IO
            InputStream inStreram = s.getInputStream();
            OutputStream outStream = s.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outStream));
            //向服务器端发送一条信息
            bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
            bw.flush();

            // 读取服务器返回的信息
            BufferedReader br = new BufferedReader(new InputStreamReader(inStreram));
            String mess = br.readLine();
            System.out.println("服务器： " + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
