package DesignPattern.Builder.Singleton;

/**
 * 步骤1
 * 单例模式的关键在于：构造函数 私有
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    // 让构造函数私有，这样该类就不会被实例化
    private SingleObject(){}

    // 获取唯一可用的对象
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
