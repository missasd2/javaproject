package jcip.chp4;

import jcip.annotate.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 程序清单4-15 通过客户端加锁来是实现 “若没有则添加”
 */
@ThreadSafe
public class ListHelper_Right<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }
}
