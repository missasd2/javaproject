package leetcode.tag.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_ThreeSum_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 枚举a
        for (int first = 0; first < n; first++) {
            // 确保每次和上一次枚举的不一样
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            // c 对应的指针指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举b
            for (int second = first+1; second < n; second++) {
                // 需要和上一次枚举的不同
                if (second > first + 1 && nums[second] == nums[second-1]) {
                    continue;
                }
                // 保证b的指针在c的指针左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，随着b后续的增加
                // 就不会有满足 a+b+c = 0 且 b<c 的 c了，可以退出循环
                if (second == third) break;
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P15_ThreeSum_1 solution = new P15_ThreeSum_1();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }
}
