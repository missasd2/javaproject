package leetcode.tag.dfs;

import leetcode.tag.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历 DFS方式
 */
public class In_Order1 {

    public List<Integer> inOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){

            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
     return list;

    }
}
