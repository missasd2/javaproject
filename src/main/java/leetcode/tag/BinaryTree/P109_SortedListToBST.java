package leetcode.tag.BinaryTree;

import java.util.List;

/**
 * P109_SortedListToBST
 */
public class P109_SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {


        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right){
        if ( left == right){
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;

    }

    /**
     * 使用快慢指针，找出链表中位数节点
     * @param left
     * @param right
     * @return
     */
    public ListNode getMedian(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
