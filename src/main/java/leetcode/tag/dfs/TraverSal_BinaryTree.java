package leetcode.tag.dfs;

import leetcode.tag.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用DFS进行二叉树的遍历
 */
public class TraverSal_BinaryTree {

    public List<Integer> preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) stack.add(temp.right);
            if (temp.left != null) stack.add(temp.left);
        }
        return list;
    }

    public List<Integer> preOrder1(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return list;

    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> InOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        if (root == null) return list;
        while (curr != null || !stack.isEmpty()){

            // 将当前节点及当前节点的左子节点进行压栈操作
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            // 弹出左子节点
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;

    }
}
