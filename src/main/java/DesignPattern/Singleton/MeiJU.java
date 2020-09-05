package DesignPattern.Singleton;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 6 枚举
 */
public enum MeiJU {
    INSTANCE;

    public void doSomething(){
        System.out.println("doSomething");
    }
}
