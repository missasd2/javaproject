package leetcode.tag.hash;

import java.util.Iterator;
import java.util.LinkedList;

/***
 * 设计哈希集合
 */
public class P705_MyHashSet {
    // 模因子取为素数
    private static final int BASE = 769;
    private LinkedList[] data;

    public P705_MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        // 哈希冲突时，的处理方法
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    // 设计哈希函数； key mod(BASE)
    private static int hash(int key) {
        return key % BASE;
    }
}
