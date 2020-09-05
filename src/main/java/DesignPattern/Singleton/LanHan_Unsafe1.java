package DesignPattern.Singleton;

/**
 * 1. 懒汉式，线程不安全
 */
public class LanHan_Unsafe1 {
    // 实例私有
    private static LanHan_Unsafe1 instance;

    // 构造函数私有
    private LanHan_Unsafe1(){}

    // 通过访问方法获取实例
    public static LanHan_Unsafe1 getInstance(){
        if (instance == null){
            instance = new LanHan_Unsafe1();
        }
        return instance;
    }


}
