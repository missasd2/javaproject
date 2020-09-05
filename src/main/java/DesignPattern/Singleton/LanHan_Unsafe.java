package DesignPattern.Singleton;

/**
 * 1. 懒汉式，线程不安全
 */
public class LanHan_Unsafe {
    private static LanHan_Unsafe instance;
    // 构造函数私有
    private LanHan_Unsafe(){}

    public static LanHan_Unsafe getInstance(){
        if (instance == null){
            instance = new LanHan_Unsafe();
        }
        return instance;
    }
}
