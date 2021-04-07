package jcip.chp1;

import jcip.annotate.GuardeBy;

/**
 * 代码清单 1-2 线程安全的数值序列生成器
 */
public class Sequence {
    @GuardeBy("this") private int Value;

    public synchronized int getNext() {
        return Value++;
    }
}
