package DesignPattern.Singleton;

/**
 * 懒汉式-线程安全
 * 优点：第一次调用才舒适化，避免内存浪费
 * 缺点：必须加锁synchronized才能保证单例，但加锁会影响效率
 */
public class LanHan_Safe {

    private static LanHan_Safe instance;
    private LanHan_Safe(){}
    public static synchronized LanHan_Safe getInstance(){
        if (instance == null){
            instance = new LanHan_Safe();
        }
        return instance;
    }
}
