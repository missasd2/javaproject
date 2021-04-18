package jcip.chp4;

import jcip.annotate.ThreadSafe;

import java.util.Vector;

/**
 * 程序清单 4-13 扩展Vector并增加一个 “若没有则添加” 方法
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}
