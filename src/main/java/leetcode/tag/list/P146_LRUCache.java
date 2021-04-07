package leetcode.tag.list;

import java.util.*;

public class P146_LRUCache {
    private Map<Integer,Integer> map = new HashMap<>();
    private List<Integer> list;
    private int capa;
    public P146_LRUCache(int capacity) {
        list = new LinkedList<Integer>();
        capa = capacity;
    }

    public int get(int key) {

        if (list.contains(key)) {
            return map.get(key);
        }
        return -1;

    }

    public void put(int key, int value) {

        // 1. 到达容量，删除缓存
        if (list.size() == capa) {
            list.remove(0);
        } else {
            // 2. 正常放入,key不存在
            if (map.containsKey(key)) {
                list.remove(key);
                list.add(key);
                map.put(key, value);
            }

            // 3. 正常放入,key不存在
            list.add(key);
            map.put(key, value);
        }
    }
}
