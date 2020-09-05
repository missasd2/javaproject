package DesignPattern.Singleton;

/**
 * 饿汉式
 * 在类加载时就初始化，因此线程安全，但浪费内存
 */
public class EHan_Safe1 {

    private static EHan_Safe1 instance = new EHan_Safe1();

    private EHan_Safe1(){}

    public EHan_Safe1 getInstance(){
        return instance;
    }
}
