package exam.haoweilai.test1;

import leetcode.tag.BinaryTree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class Solution1 {
    public String notReCuPreOrder (TreeNode root) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        if (root == null) return builder.toString();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            builder.append(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }

        return builder.toString();
    }

    public String notReCuPreOrder_1 (TreeNode root) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        if (root == null) return builder.toString();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            builder.append(curr.val).append(",");
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }

        String res = builder.substring(0, builder.length()-1);

        return res;
    }
}
