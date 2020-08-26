package CoreVolumeTow.chp3.Socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketTest2 {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("baidu.com");
        byte[] address1 = address.getAddress();
        // baidu.com/39.156.69.79
        System.out.println(address);
        // baidu.com
        System.out.println(address.getHostName());
        // 39.156.69.79
        System.out.println(address.getHostAddress());

        System.out.println("------------------------");
        /**
         * getAllByName方法来获得所有主机
         * hostname is : baidu.com ip is 220.181.38.148
         * hostname is : baidu.com ip is 39.156.69.79
         */
        InetAddress[] allByName = InetAddress.getAllByName("baidu.com");
        for (InetAddress address2: allByName){
            System.out.println("hostname is : "+ address2.getHostName() + " ip is " + address2.getHostAddress());
        }
        // DESKTOP-S7RKO7P/169.254.70.9
        System.out.println(InetAddress.getLocalHost());

    }
}
