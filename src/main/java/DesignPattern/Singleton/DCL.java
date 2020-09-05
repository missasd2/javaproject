package DesignPattern.Singleton;

/**
 * 4 双重检验锁
 * 问题：为什么需要两次判断if(singleTon==null)?
 * 第一次校验：由于单例模式只需要创建一次实例，如果后面再次调用getInstance()方法，则直接返回之前创建的实例
 *  一次大部分时间不需要执行同步方法里面的代码，提高了性能。如果不加第一次校验的话则和懒汉式没什么区别，每次都要去竞争锁
 *
 *  第二次校验：
 */
public class DCL {
    private volatile static DCL instance;
    private DCL(){}
    public static DCL getInstance(){
        if (instance == null){
            synchronized (DCL.class){
                if (instance == null){
                    instance = new DCL();
                }
            }
        }
        return instance;
    }
}
