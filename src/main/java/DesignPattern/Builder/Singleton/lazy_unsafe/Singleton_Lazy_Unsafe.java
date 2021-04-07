package DesignPattern.Builder.Singleton.lazy_unsafe;

/**
 * 1 懒汉式-线程不安全
 * 严格来所不算 单例模式
 */
public class Singleton_Lazy_Unsafe {

    private static Singleton_Lazy_Unsafe instance;
    // 构造函数私有
    private Singleton_Lazy_Unsafe(){}

    public static Singleton_Lazy_Unsafe getInstance() {
        // 判断实例是否为空，
        // 当第一次访问时，此时为空，才创建单例对象
        if (instance == null) {
            instance = new Singleton_Lazy_Unsafe();
        }
        return instance;
    }

}
