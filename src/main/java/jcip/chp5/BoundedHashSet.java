package jcip.chp5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 程序清单 5-14 使用Semaphore 将任何一种容器变为 有界阻塞容器
 * @param <T>
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound); // 设定许可的数量; 初始化信号量计数器的初始值
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire(); // 获取许可；如果获取不到则阻塞当前线程
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        }
        finally {
            if (!wasAdded) {
                sem.release(); // 如果添加失败，则释放许可
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            sem.release();
        }
        return wasRemoved;
    }




}
