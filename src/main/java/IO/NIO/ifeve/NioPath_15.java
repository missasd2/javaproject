package IO.NIO.ifeve;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *  java中的Path表示文件系统的路径。可
 *  以指向文件或文件夹。
 *  也有相对路径和绝对路径之分。
 *  绝对路径表示从文件系统的根路径到文件或是文件夹的路径。
 *  相对路径表示从特定路径下访问指定文件或文件夹的路径。
 */
public class NioPath_15 {

    public static void main(String[] args) {
        // 使用Paths 类的静态方法Paths.get()来产生一个实例；它是一个工厂方法
        Path path = Paths.get("tinyT.txt");

        // Path.normalize()方法，可以标准化路径
        //标准化的含义是路径中的.和..都被去掉，指向真正的路径目录地址
        String originalPath =
                "d:\\data\\projects\\a-project\\..\\another-project";
        Path path1 = Paths.get(originalPath);
        System.out.println("path1 " + path1);

        Path path2 = path1.normalize();
        System.out.println("path2 " + path2);

        //=================
        Path path3 = Paths.get("data/logging.properties");
        boolean exists = Files.exists(path3, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        System.out.println(exists);
        //AtomicReference 解决AtomicInteger只能保证一个共享变量的原子操作；


    }
}
