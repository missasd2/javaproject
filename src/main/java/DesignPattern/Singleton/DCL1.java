package DesignPattern.Singleton;

/**
 * 4 双重校验锁
 */
public class DCL1 {

    private volatile static DCL1 instance;

    private DCL1(){}

    public DCL1 getInstance(){
        if (instance == null){
            synchronized (DCL1.class){
                if (instance == null){
                    instance = new DCL1();
                }
            }
        }
        return instance;
    }


}
