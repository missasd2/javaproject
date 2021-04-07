package DesignPattern.Builder.Singleton;

public class SingletonPatternDemo {

    public static void main(String[] args) {
        // 不合法的构造函数
        //SingleObject_1 singleObject_1 = new SingleObject_1();

        SingleObject instance = SingleObject.getInstance();
        SingleObject instance_1 = SingleObject.getInstance();
        System.out.println(instance == instance_1);
    }
}
