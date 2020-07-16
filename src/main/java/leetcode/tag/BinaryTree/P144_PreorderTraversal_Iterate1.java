package leetcode.tag.BinaryTree;

import leetcode.num.linkedlist.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P144_PreorderTraversal_Iterate1 {
    public List<Integer> preorderTraversal(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null) {

                stack.add(node.left);
            }
        }
        return output;

    }

}
