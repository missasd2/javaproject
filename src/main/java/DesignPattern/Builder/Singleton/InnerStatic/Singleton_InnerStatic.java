package DesignPattern.Builder.Singleton.InnerStatic;

/**
 * 单例模式-静态内部类
 * 利用了classloader 机制来保证初始化instance时，只有一个线程。
 * Singleton_InnerStatic 类即使被装载了，instance不一定被初始化。
 * 只有通过显式调用 getInstance()方法，才会显式装载 SingletonHolder类，从而实例化instance。
 */
public class Singleton_InnerStatic {

    private static class SingletonHolder {
        // 静态域 使用延迟初始化
        private static final Singleton_InnerStatic instance = new Singleton_InnerStatic();
    }

    // 构造函数私有化
    private Singleton_InnerStatic(){}

    public static Singleton_InnerStatic getInstance(){
        return SingletonHolder.instance;
    }
}
