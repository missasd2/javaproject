package CoreVolumeTow.chp3.urlConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            String urlName;
            if (args.length > 0) urlName = args[0];
            else urlName = "http://horstmann.com";

            URL url = new URL(urlName);
            // 1）调用URL类中的openConnection方法获得URLConnection对象：
            URLConnection connection = url.openConnection();

            if (args.length < 2){
//                String username = args[1];
                String username = "tom";
                //String password = args[2];
                String password = "123456";
                String input = username + ":" + password;
                // 计算所得字符串的Base64编码。
                // （Base64编码用于将字节序列编码成可打印的ASCII字符序列。）
                Base64.Encoder encoder = Base64.getEncoder();
                String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
                // 2）使用以下方法来设置请求属性：
                connection.setRequestProperty("Authorization", "Basic" + encoding);
            }
            // 3）调用connect方法连接远程资源：
            connection.connect();;

            // print header fields
            // 4)getHeaderFields方法返回一个包含了消息头中所有字段的标准Map对象。
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()){
                String key = entry.getKey();
                for (String value : entry.getValue()){
                    System.out.println(key + ":" + value);
                }
            }

            // 打印相关信息
            System.out.println("----------");
            System.out.println("getContentType: " + connection.getContentType());
            System.out.println("getContentLength: " + connection.getContentLength());
            System.out.println("getContentEncoding: " + connection.getContentEncoding());
            System.out.println("getDate: " + connection.getDate());
            System.out.println("getExpiration: " + connection.getExpiration());
            System.out.println("getLastModified: " + connection.getLastModified());
            System.out.println("----------");

            String encoding = connection.getContentEncoding();
            if (encoding == null) encoding = "UTF-8";
            // 5）最后，访问资源数据。使用getInputStream方法获取一个输入流用以读取信息
            try (Scanner in = new Scanner(connection.getInputStream(), encoding);){
                // print first ten linees of contents

                for (int n = 1; in.hasNextLine() && n<=10 ; n++) {
                    System.out.println(in.nextLine());
                    if (in.hasNextLine()) System.out.println("...");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
