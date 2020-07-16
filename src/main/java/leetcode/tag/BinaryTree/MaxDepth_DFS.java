package leetcode.tag.BinaryTree;

import javafx.util.Pair;

import java.util.LinkedList;

public class MaxDepth_DFS {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair(root, 1));
        int maxDepth = 0;
        // DFS实现前序遍历
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            // 更新最大深度
            maxDepth = Math.max(maxDepth, pair.getValue());
            //
            int curDepth = pair.getValue();
            // 当前节点的子节点入栈，同时深度+1
            // 先将右子节点入栈，然后左子节点入栈；这样pop()出来遍历的就是先左再右
            if (node.right != null){
                stack.push(new Pair(node.right, curDepth+1));
            }
            if (node.left != null){
                stack.push(new Pair(node.left, curDepth+1));
            }
        }
        return maxDepth;

    }
}
