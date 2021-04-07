package DesignPattern.Builder.Singleton.lazy_safe;

/**
 * 懒汉式-线程安全
 */
public class Singleton_Lazy_Safe {
    private static Singleton_Lazy_Safe instance;
    private Singleton_Lazy_Safe(){}

    // 加锁; 保证多线程情境下仍是单例
    public synchronized Singleton_Lazy_Safe getInstance() {
        // 第一次调用，才开始初始化
        if (instance == null) {
            instance = new Singleton_Lazy_Safe();
        }
        return instance;
    }
}
