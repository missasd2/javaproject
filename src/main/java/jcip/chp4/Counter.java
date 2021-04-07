package jcip.chp4;

import jcip.annotate.GuardeBy;
import jcip.annotate.ThreadSafe;

/**
 * 程序清单4-1 使用Java监视器模式的线程安全计数器
 */
@ThreadSafe
public class Counter {
    @GuardeBy("this") private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }
}
