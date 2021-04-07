package leetcode.tag.array.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * P90 子集II
 */
public class P90_SubsetsWithDup {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            boolean flag = true;
            // 内循环，代表每次对n个数进行取舍
            for (int i = 0; i < n; i++) {
                // 内循环中，如果某个数字被取到
                if ((mask & (1 << i)) != 0) {
                    // 从第二次开始  &&  如果前一次没取到，这次取到了 &&  两个相同的数;
                    // 则flag为false，表示有重复情况; 结束内循环
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }

            }
            if (flag) {
                ans.add(new ArrayList<Integer>(t));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P90_SubsetsWithDup solution = new P90_SubsetsWithDup();
        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
        System.out.println(" ");
    }
}
