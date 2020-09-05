package DesignPattern.Singleton;

/**
 * 5 登记式/静态内部类
 * 这种方式能达到双检锁方式一样的功效，但实现更简单。
 * 对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
 * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 */
public class Register_StaticInner {

    /**
     * 与饿汉式不同的是，它是在内部类里面去创建对象实例
     * 只要应用中不使用内部类，JVM就不会加载这个单例类，也就不会创建单例对象
     * 从而实现懒汉式的延迟加载。
     *
     * 外部类被装载了，instance不一定被初始化。
     * 因为内部类没有被主动使用，若显式调用外部类的getInstance()方法
     * 才会显式装载内部类，从而实例化instance。
     * */


    private static class Register_StaticInner_Holder{
        private static final Register_StaticInner INSTANCE = new Register_StaticInner();
    }

    private Register_StaticInner(){}

    public static final Register_StaticInner getInstance(){
        return Register_StaticInner_Holder.INSTANCE;
    }
}
