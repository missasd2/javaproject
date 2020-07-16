package leetcode.tag.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历-基于栈
 */
public class P94_InorderTraversal_Stack {
    public List<Integer> inorderTraversal_recurse(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while ( curr != null || !stack.isEmpty()){

            // 从左一直遍历到底，并压入栈
            while ( curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;

        }
    return res;

    }





}
