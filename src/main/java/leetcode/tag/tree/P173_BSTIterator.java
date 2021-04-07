package leetcode.tag.tree;


import leetcode.num.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P173_BSTIterator {
    private int idx;
    private List<Integer> arr;

    public P173_BSTIterator(TreeNode root) {
        idx = 0;
        arr = new ArrayList<Integer>();
        inorderTraversal(root, arr);
    }
    public int next() {
        return arr.get(idx++);
    }
    public boolean hasNext() {
        return idx < arr.size();
    }
    private void inorderTraversal(TreeNode root, List<Integer> arr){
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
}
