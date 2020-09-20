package exam.baidu.test1;

import edu.princeton.cs.algs4.In;
import leetcode.tag.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2 {
    public ArrayList<ArrayList<Integer>> printNode(TreeNode node) {
        // write code here
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<>();
        if (node == null){
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                if (left != null) queue.offer(left);
                if (right != null) queue.offer(right);
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }
}
