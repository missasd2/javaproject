package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        helper(root, res);
        return res;
    }

    void helper(TreeNode root, List<Integer> res){
        if (root == null)
            return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}
