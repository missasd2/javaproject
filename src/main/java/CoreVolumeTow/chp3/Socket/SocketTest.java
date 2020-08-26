package CoreVolumeTow.chp3.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 程序清单3-1 连接到某个端口并打印出它所找到的信息。
 * 结果：59087 20-08-26 07:31:48 50 0 0 836.6 UTC(NIST) *
 *
 */
public class SocketTest {
    public static void main(String[] args) {
        try {
            /**
             * 用于打开一个套接字，它也是网络软件中的一个抽象概念，
             * 负责启动该程序内部和外部之间的通信。
             * 我们将远程地址和端口号传递给套接字的构造器，
             * 如果连接失败，它将抛出一个UnknownHostException异常；
             * 如果存在其他问题，它将抛出一个IOException异常
             * 另外还有一个超时问题是必须解决的。
             * 下面这个构造器：会一直无限期地阻塞下去，
             * 直到建立了到达主机的初始连接为止
             */
            // Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
            Socket s = new Socket();
            s.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13), 10000);
            // 为套接字设置超时值,
            // 并且之后的读操作和写操作在没有完成之前就超过了时间限制，
            // 那么这些操作就会抛出SocketTimeoutException异常。
            s.setSoTimeout(10000);
            InputStream inStream = s.getInputStream();
            Scanner inScanner = new Scanner(inStream);
            while (inScanner.hasNextLine()){
                String line = inScanner.nextLine();
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
