package DesignPattern.Builder.Singleton.starve;

/**
 * 单例-饿汉式
 * 立即加载：在类加载初始化的时候，
 *          就实例化一个对象并交给，自己的私有静态引用。
 * 类是按需加载，且在类的生命周期中仅加载一次，因此天然线程安全。
 */
public class Singleton_Starve {
    private static Singleton_Starve instance = new Singleton_Starve();

    private Singleton_Starve(){}

    public static Singleton_Starve getInstance() {
        return instance;
    }
}
