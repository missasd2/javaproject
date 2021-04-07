package DesignPattern.Builder.Singleton.doubleCheck;

/**
 * 单例模式- 双重检查
 */
public class Singleton_Double_1 {
    private static volatile Singleton_Double_1 instance;
    private Singleton_Double_1() {}

    public static Singleton_Double_1 getInstance() {
        if (instance == null) {
            synchronized (Singleton_Double_1.class) {
                if (instance == null) {
                    instance = new Singleton_Double_1();
                }
            }
        }
        return instance;
    }
}
