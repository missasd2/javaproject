package CoreVolumeTow.chp1_fileStream.p1;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        // 获取用户工作目录;D:\java\javaproject
        String property = System.getProperty("user.dir");
        // 常量字符串：程序所运行平台的文件分隔符 \
        String separator = File.separator;
        System.out.println(separator);

        System.out.println(property);

        // 读入文本输入
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入姓名");
        String note = bufferedReader.readLine();

        // 文本输出
        PrintWriter out = new PrintWriter("employee.txt");
        String name = "Harry Hacker";
        System.out.println(note);
        out.print(name);
        out.print(note);


    }
}
