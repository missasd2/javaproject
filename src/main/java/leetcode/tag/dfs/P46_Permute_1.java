package leetcode.tag.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P46_Permute_1 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        for (int num : nums) {
            tmp.add(num);
        }
        int n = nums.length;
        if (n == 0) return res;
        dfs(res, tmp, 0, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, int first, int n) {
        if (first == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = first; i < n; i++) {

            Collections.swap(tmp, first, i);
            dfs(res, tmp, first+1, n);
            Collections.swap(tmp, first, i);

        }
    }

}
