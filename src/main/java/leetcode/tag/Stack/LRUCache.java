package leetcode.tag.Stack;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capaticy;

    public LRUCache(int capaticy){
        super(capaticy, 0.75F, true);
        this.capaticy = capaticy;

    }

    public int get(int key){
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capaticy;
    }
}
