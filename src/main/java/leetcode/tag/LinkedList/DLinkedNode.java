package leetcode.tag.LinkedList;

/**
 * 双向链表的节点
 */
public class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode(){}
    public DLinkedNode(int _key, int _value){key = _key; value = _value;}
}
