package jcip.chp4;

import JavaSE.Serializable.Person;
import jcip.annotate.GuardeBy;

/**
 * 程序清单4-3 通过一个私有锁来保护状态
 * ji
 */
public class UserPrivateLock {
    private final Object myLock = new Object();
    @GuardeBy("myLock") Person person;

    void someMethod() {

        synchronized (myLock) {  // 私有的锁对象
            // 访问或修改 Person的状态; 封装状态变量Person
        }
    }
}
