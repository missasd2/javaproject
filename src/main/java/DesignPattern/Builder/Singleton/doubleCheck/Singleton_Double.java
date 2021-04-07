package DesignPattern.Builder.Singleton.doubleCheck;

/**
 * 单例模式：双重检查
 */
public class Singleton_Double {
    private volatile static Singleton_Double instance;
    private Singleton_Double(){}

    public static Singleton_Double getInstance(){
        if(instance == null) {
            synchronized (Singleton_Double.class) {
                if (instance == null) {
                    instance = new Singleton_Double();
                }
            }
        }
        return instance;
    }
}
