package DesignPattern.Builder.Singleton.lazy_safe;

/**
 * 单例模式-懒汉式-线程安全
 */
public class Singleton_Lazy_Safe_1 {
    private static Singleton_Lazy_Safe_1 instance;
    private Singleton_Lazy_Safe_1(){}

    public static synchronized Singleton_Lazy_Safe_1 getInstance() {
        // 仅当第一次访问时，才进行实例化
        if (instance == null) {
            instance = new Singleton_Lazy_Safe_1();
        }
        return instance;
    }
}
