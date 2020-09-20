package leetcode.tag.Array;

import java.util.ArrayList;
import java.util.List;

public class P46_permutate {

    public List<List<Integer>> permutate(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return res;

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, used, path, res);
        return res;

    }

    public  void dfs(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res){
        // 终止条件
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i < len; i++){
            if (!used[i]){
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, len, depth+1, used, path, res);
                // 回溯
                used[i] = false;
                path.remove(path.size()-1);
            }
        }


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        P46_permutate p46_permutate = new P46_permutate();
        List<List<Integer>> permutate = p46_permutate.permutate(nums);
        System.out.println(permutate);
    }
}


