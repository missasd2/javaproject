package CoreVolumeTow.chp3.post;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class PostTest {
    public static void main(String[] args) {
        // 加载配置文件
        String propath = "src\\main\\java\\CoreVolumeTow\\chp3\\post\\post.properties";
        String propsFilename = args.length > 0 ? args[0] : propath;
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(propsFilename))){
            props.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }
        String uslString = props.remove("url").toString();
        Object userAgent = props.remove("User-Agent");
        Object redirects = props.remove("redirects");
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

    }

    public static String doPost(URL url, Map<Object, Object> nameValuePairs, String userAgent, int redirects) throws IOException {
        // 创建一个URLConnection对象
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        if (userAgent != null){
            connection.setRequestProperty("User-Agent", userAgent);
        }
        
        if (redirects >= 0){
            connection.setInstanceFollowRedirects(false);
        }
        // 调用setDoOutput方法建立一个用于输出的连接
        connection.setDoOutput(true);


        try (
                // 调用getOutputStream方法获得一个流，可以通过这个流向服务器发送数据。
                // 如果要向服务器发送文本信息，
                // 那么可以非常方便地将流包装在PrintWriter对象中。
                PrintWriter out = new PrintWriter(connection.getOutputStream())){
            boolean first = true;
            for (Map.Entry<Object, Object> pair : nameValuePairs.entrySet()){
                if (first) first = false;
                else out.print('&');
                String name = pair.getKey().toString();
                String value = pair.getValue().toString();
                // 向服务器发送数据
                out.print(name);
                out.print('=');
                // 采用指定的字符编码模式
                // （推荐使用“UTF-8”）对字符串s进行编码，并返回它的URL编码形式。
                out.print(URLEncoder.encode(value, "UTF-8"));
            }
        }
        String encoding = connection.getContentEncoding();
        if (encoding == null) encoding = "UTF-8";

        if (redirects > 0){
           int responseCode = connection.getResponseCode();
           if (responseCode == HttpURLConnection.HTTP_MOVED_PERM
                   || responseCode == HttpURLConnection.HTTP_MOVED_TEMP
                   || responseCode == HttpURLConnection.HTTP_SEE_OTHER
           ){
               String location = connection.getHeaderField("Location");
               if (location != null){
                   URL base = connection.getURL();
                   connection.disconnect();
                   return doPost(new URL(base, location), nameValuePairs, userAgent, redirects - 1);
               }
           }
        }
        else if (redirects == 0){
            throw new IOException("Too many redirects");
        }

        StringBuilder response = new StringBuilder();
        try (Scanner in = new Scanner(connection.getInputStream(), encoding)){
            while (in.hasNextLine()){
                response.append(in.nextLine());
                response.append("\n");
            }
        }catch (IOException e){
            // 捕捉错误页，
            // 可以将URLConnection对象转型为HttpURLConnection类
            // 并调用它的getErrorStream方法：
            InputStream err = connection.getErrorStream();
            if (err == null) throw e;
            try (Scanner in = new Scanner(err)){
                response.append(in.nextLine());
                response.append("\n");
            }
        }
        return response.toString();
    }
}
