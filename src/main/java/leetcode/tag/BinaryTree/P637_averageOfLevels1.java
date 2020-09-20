package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层平均值——DFS
 */
public class P637_averageOfLevels1 {
    public List<Double> averageOfLevels(TreeNode root) {

        ArrayList<Double> res = new ArrayList<>();
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        int level = 0;
        dfs(root, sum, count, level);
        for (int i = 0; i < sum.size(); i++){
            res.add(sum.get(i) / count.get(i));
        }

        return res;
    }

    // 记录每层的和
    public void dfs(TreeNode root, List<Double> sum, List<Integer> counts, int level){
        if (root == null) return;
        if (level < sum.size()){
            sum.set(level, sum.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        }else {
            sum.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, sum, counts, level + 1);
        dfs(root.right, sum, counts, level + 1);

    }

    // 记录每层的和
    public void dfs1(TreeNode root, List<Double> sum, List<Integer> count, int level){
        if (root == null) return;
        if (level < sum.size()){
            sum.set(level, sum.get(level) + root.val);
            count.set(level, count.get(level) + 1);
        }else {
            sum.add(1.0 * root.val);
            count.add(1);
        }
        dfs(root.left, sum, count, level + 1);
        dfs(root.right, sum, count, level + 1);
    }

    public static void main(String[] args) {

    }


}
