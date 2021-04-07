package leetcode.tag.array.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90_SubsetsWithDup_1 {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int mask = 0;  mask < (1 << n); mask++) {
            // 每次将t清空
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<>(t));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P90_SubsetsWithDup_1 solution = new P90_SubsetsWithDup_1();
        System.out.println(solution.subsetsWithDup(new int[] {1, 2, 2}));
    }
}
