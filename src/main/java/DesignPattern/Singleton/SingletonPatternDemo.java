package DesignPattern.Singleton;

public class SingletonPatternDemo {

    public static void main(String[] args) {
        // 不合法的构造函数
        // 编译时错误：构造函数 SingleObject()是不可见的
        // SingleObject object = new SingleObject.getInstance();
        SingleObject obj = SingleObject.getInstance();
        obj.showMessage();
    }
}
