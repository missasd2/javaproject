package leetcode.tag.Tree;

import leetcode.tag.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class P94_InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){

            // 如果有左子节点，则将其压栈;最终到达的是最最左边的叶子节点
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            // 弹出叶子节点，将中的值加入list
            curr = stack.pop();
            list.add(curr.val);
            // 模拟的是右的过程
            curr = curr.right;
        }
        return list;
    }
}
