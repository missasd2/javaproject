package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层平均值——BFS
 */
public class P637_averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {

        ArrayList<Double> res = new ArrayList<>();
        res = helper(root, res);
        return res;
    }

    public ArrayList<Double> helper(TreeNode root, ArrayList<Double> res){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0){
            double num = 0;
            int count = queue.size();

            for (int i = 0; i < count; i++){
                TreeNode cur = queue.poll();
                num += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add((double) num/count);

        }

        return res;

    }
}
