package DesignPattern.Builder.Singleton;

public class SingleObject_1 {
    private static SingleObject_1 Instance = new SingleObject_1();

    // 构造函数私有的，这样该类就不会被实例化
    private SingleObject_1(){};

    public static SingleObject_1 getInstance(){
        return  Instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
