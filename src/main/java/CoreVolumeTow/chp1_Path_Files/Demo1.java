package CoreVolumeTow.chp1_Path_Files;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 静态的Paths.get方法接受一个或多个字符串，
 * 并将它们用默认文件系统的路径分隔符（
 * 类Unix文件系统是/，Windows是\）连接起来。
 * 然后它解析连接起来的结果，
 * 如果其表示的不是给定文件系统中的合法路径，
 * 那么就抛出InvalidPathException异常。
 * 这个连接起来的结果就是一个Path对象。
 */
public class Demo1 {
    // \home\cay
    //   myprog\\conf\\user.properties
    public static void main(String[] args) {
        Path absolute = Paths.get("/home", "cay");
        Path relative = Paths.get("myprog", "conf", "user.properties");
        System.out.println(absolute);
        System.out.println(relative);

    }
}
