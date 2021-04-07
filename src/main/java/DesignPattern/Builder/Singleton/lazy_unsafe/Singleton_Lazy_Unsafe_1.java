package DesignPattern.Builder.Singleton.lazy_unsafe;

public class Singleton_Lazy_Unsafe_1 {

    private static Singleton_Lazy_Unsafe_1 instance;

    // 构造函数私有
    private Singleton_Lazy_Unsafe_1(){}

    public static Singleton_Lazy_Unsafe_1 getInstance(){
        if (instance == null) {
            instance = new Singleton_Lazy_Unsafe_1();
        }
        return instance;
    }
}
