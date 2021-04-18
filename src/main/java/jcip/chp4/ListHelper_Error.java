package jcip.chp4;

import jcip.annotate.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 程序清单4-14 非线程安全的“若没有则添加” （本代码为错误代码）
 */
@NotThreadSafe
public class ListHelper_Error<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }
}
