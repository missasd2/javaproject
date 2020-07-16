package leetcode.tag.Stack;

import com.sun.media.sound.DLSInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU : 哈希表+双向链表
 */

public class LRUCache_map_linkedlist {
    // 实现双向链表
    class DLinkeNode{
        int key;
        int value;
        DLinkeNode prev;
        DLinkeNode next;
        public DLinkeNode(){}
        public DLinkeNode(int _key, int _value){key = _key; value = _value;}
    }

    // 用于存储数据
    private Map<Integer, DLinkeNode> cache = new HashMap<Integer, DLinkeNode>();
    private int size;
    private int capacity;
    private DLinkeNode head, tail;

    // 初始化
    public LRUCache_map_linkedlist(int capacity){
        // 链表长度
        this.size = 0;
        // 最大容量
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkeNode();
        tail = new DLinkeNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key){
        DLinkeNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        // 如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DLinkeNode node = cache.get(key);
        if (node == null){
            // 如果key不存在，则创建一个新的节点
            DLinkeNode newNode = new DLinkeNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity){
                // 如果超出容量,删除双向链表的尾部节点
                DLinkeNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果key存在，先通过哈希表定位，再修改value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 将链表头部添加节点，时间O(1)
    private void addToHead(DLinkeNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除某一个节点
    private void removeNode(DLinkeNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkeNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除链表最后一个节点，并返回该节点
    private DLinkeNode removeTail(){
        DLinkeNode res = tail.prev;
        removeNode(res);
        return res;
    }




}
