package exam.haoweilai.test1;

import leetcode.daily.ListNode;
import leetcode.tag.BinaryTree.TreeNode;

public class Solution2 {
    public ListNode reverseList (ListNode head) {
        if (head == null) return head;
        // write code here


        if( head.next == null) return head;
        ListNode prev = new ListNode();
        ListNode curr = head;
        prev.next = curr;

        while ( prev.next != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
