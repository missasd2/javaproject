package DesignPattern.Builder.Singleton.meiju;

/**
 * 单例模式-声明单一元素的枚举类
 * 可避免多线程问题，还自动支持序列化机制
 * 防止反序列化重新创建新的对象，绝对防止多次实例化。
 */
public enum Singleton_Enum {
    INSTANCE;
    public void leaveTheBuilding(){}

}
