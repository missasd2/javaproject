package leetcode.tag.dfs;

import leetcode.tag.BinaryTree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P98_IsValidBST1 {

    public List<Integer> preOrder(TreeNode root){
        // DFS 遍历二叉树
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return res;
    }
}
