package leetcode.tag.link;

import leetcode.num.linkedlist.ListNode;

import java.util.List;

/**
 * P92 反转链表II
 */
public class P92_ReverseBetween {
    // 方法一
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1); // 1. 使用虚拟头节点
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第1步：从虚拟头节点走 left -1 步，来到left节点的前一个节点
        // 建议写在 for循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第2步：从pre再走 right - left + 1步，来到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第3步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;
        // 第4步：同第206题，反转链表的子区间
        reverseLinkedList(leftNode);
        // 第5步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
