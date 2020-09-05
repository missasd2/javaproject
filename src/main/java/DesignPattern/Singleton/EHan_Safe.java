package DesignPattern.Singleton;

/**
 * 3 饿汉式
 * 线程安全
 * 优点：没有加锁，执行效率会提高
 * 缺点：类加载时就初始化，浪费内存
 */
public class EHan_Safe {

    private static EHan_Safe instance = new EHan_Safe();

    private EHan_Safe(){}

    public static EHan_Safe getInstance(){
        return instance;
    }
}
