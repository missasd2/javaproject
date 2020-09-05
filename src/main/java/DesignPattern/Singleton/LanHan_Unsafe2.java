package DesignPattern.Singleton;

/**
 * 1. 懒汉式，线程不安全
 */
public class LanHan_Unsafe2 {
    // 实例属性私有
    // 当程序中使用了static关键字进行定义之后，
    // 那么此属性将不保存在堆内存之中
    // 会保存在一个全局数据区的内存空间之中。
    // 并且所有的对象都可以进行该数据区的访问。
    private static LanHan_Unsafe2 instance;

    // 构造函数私有
    private LanHan_Unsafe2(){}

    // 外部通过类方法获取唯一实例
    public static LanHan_Unsafe2 getInstance(){
        if (instance == null){
            instance = new LanHan_Unsafe2();
        }
        return instance;
    }


}
