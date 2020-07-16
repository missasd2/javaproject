package leetcode.tag.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LruCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部 伪尾部
        DLinkedNode head = new DLinkedNode();
        DLinkedNode tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DLinkedNode node = cache.get(key);
        if (node == null){
            // 节点不存在则创建一个新节点，并添加进cache，更新size
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity){
                // 如果超出双向链表的容量
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.value);
                --size;
            }
        }
        else {
            // 节点存在于cache中,则更新值，并移到链表的头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
    }
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        moveToHead(node);
    }

    // 删除最后一个节点，并返回
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


}
