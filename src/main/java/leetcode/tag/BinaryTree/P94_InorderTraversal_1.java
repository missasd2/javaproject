package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class P94_InorderTraversal_1 {
    public int[] inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        helper(root,  list);
        int size = list.size();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = list.get(i);
        }
        return a;

    }

    private void helper(TreeNode root, List<Integer> list){
        if (root.left != null) helper(root.left, list);
        list.add(root.val);
        if (root.right != null) helper(root.right, list);
    }
}
