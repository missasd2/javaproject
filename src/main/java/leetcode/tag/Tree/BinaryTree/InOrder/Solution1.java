package leetcode.tag.Tree.BinaryTree.InOrder;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    // 基于栈的DFS
    public List<Integer> preOrderTraversal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null){
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return output;
    }
    // 莫里斯遍历

}
