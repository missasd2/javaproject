package DesignPattern.Singleton;

/**
 * 创建一个Singleton类
 * 注意：
 *      1. 单例类只能有一个实例
 *      2. 单例类必须自己创建自己的唯一实例
 *      3. 单例类必须给所有其它对象提供这一实例
 */
public class SingleObject {

    // 本身的一个静态实例 instance
    private static SingleObject instance = new SingleObject();

    // 构造函数私有
    private SingleObject(){}

    // 静态方法提供给外部使用
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
