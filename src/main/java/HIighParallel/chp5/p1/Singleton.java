package HIighParallel.chp5.p1;

/**
 * chp5.1 单例模式
 */
public class Singleton {
    // 构造函数设置为private
    private Singleton(){
        System.out.println("Singleton is create");
    }

    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
