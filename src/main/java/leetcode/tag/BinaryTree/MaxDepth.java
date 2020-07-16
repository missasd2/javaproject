package leetcode.tag.BinaryTree;
/**
 * 层序遍历
 */

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root){
        Queue<Pair<TreeNode, Integer>>  stack = new LinkedList<>();
        if (root != null){
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null){
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth+1));
                stack.add(new Pair(root.right, current_depth+1));
            }
        }
        return depth;
    }

}
