package leetcode.tag.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 */
public class P94_InorderTraversal {
    public List<Integer> inorderTraversal_recurse(TreeNode root){
        List<Integer > res = new LinkedList<>();
        helper(root, res);
        return res;

    }

    public void helper(TreeNode root, List<Integer> res){
        if (root != null){
            if (root.left != null){
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null){
                helper(root.right, res);
            }
        }
    }
}
