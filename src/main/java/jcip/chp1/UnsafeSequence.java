package jcip.chp1;

import jcip.annotate.NotThreadSafe;

/**
 * 程序清单1-1
 * 1.3.1 安全性问题
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    // 返回一个唯一的数值
    public int getNext() {
        return value++;
    }
}
