package leetcode.tag.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树前序遍历
 */
public class P144_PreorderTraversal_Iterate {
    public List<Integer> preorderTraversal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null){
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null){
                stack.add(node.left);
            }
        }
        return output;
    }
}
