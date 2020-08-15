package CoreVolumeTow.chp1_fileStream.p1;

import java.io.*;
import java.nio.charset.Charset;

public class Demo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 保存对象数据
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Employee linus = new Employee("Linux Hacker", 60000, 1990, 10, 1);
        out.writeObject(harry);
        out.writeObject(linus);

        // 从文件流中将对象读回
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.txt"));
        Employee e1 = (Employee) in.readObject();
        Employee e2 = (Employee) in.readObject();
        System.out.println(e1);
        System.out.println(e2);

    }
}
