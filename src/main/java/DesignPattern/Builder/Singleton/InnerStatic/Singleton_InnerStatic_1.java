package DesignPattern.Builder.Singleton.InnerStatic;

/**
 * 单例模式-静态内部类
 */
public class Singleton_InnerStatic_1 {

    private static final class SingletonHolder_1{
        private static final Singleton_InnerStatic_1 instance = new Singleton_InnerStatic_1();
    }

    private Singleton_InnerStatic_1(){}

    public static Singleton_InnerStatic_1 getInstance() {
        return SingletonHolder_1.instance;
    }
}
