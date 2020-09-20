package leetcode.tag.Array;

import java.util.ArrayList;
import java.util.List;

public class P46_permute {
    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    /**
     *
     * @param nums 用来进行选择的元素
     * @param len 元素数组的长度
     * @param depth 每次dfs所在的层数
     * @param path 记录每条路径上的节点
     * @param used 记录哪些节点已经使用
     * @param res 总的结果
     */
    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[]used, List<List<Integer>>res){
        // 截止条件，到达叶子节点
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子节点处，产生不同的分支；
        // 在还未选择的数中一次选择一个元素作为下一个位置的元素，通过循环实现
        for (int i = 0; i < len; i++){
            if (!used[i]){
                path.add(nums[i]);
                // 表明选择了这个元素
                used[i] = true;

                dfs(nums, len, depth+1, path, used,res);
                // 回溯，发生在从 深层节点 回到浅层节点的过程
                // 代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        P46_permute p46_permute = new P46_permute();
        List<List<Integer>> lists = p46_permute.permute(nums);
        System.out.println(lists);
    }
}
