package CoreVolumeTow.chp3.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        // establish server socket
        try {
            // 建立套接字
            ServerSocket s = new ServerSocket(8189);
            // 告诉程序不停地等待，直到有客户端连接到这个端口
            // 一旦有人通过网络发送了正确的连接请求，并以此连接到了端口上，
            // 该方法就会返回一个表示连接已经建立的Socket对象。
            Socket incoming = s.accept();
            // 使用这个Socket对象来得到输入流和输出流
            // 服务器发送给服务器输出流的所有信息都会成为客户端程序的输入，
            // 同时来自客户端程序的所有输出都会被包含在服务器输入流中。
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            Scanner inSc = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true);

            out.println("Hello! Enter BYE to exit.");

            // echo client input
            boolean done = false;
            while (!done && inSc.hasNextLine()){
                String line = inSc.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) done = true;
            }
            incoming.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
