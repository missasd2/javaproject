package leetcode.tag.set;

import java.util.TreeSet;
import java.util.Vector;

/**
 * 有序集合、滑动窗、桶排序
 */
public class P220_ContainsNearbyAlmostDuplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {

            // ceiling() 表示向上取整，即大于括号中表达式值的 最小元素
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            // 如果窗口超限，则删除最旧的元素
            if ( i >= k){
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        P220_ContainsNearbyAlmostDuplicate_III solution = new P220_ContainsNearbyAlmostDuplicate_III();
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 3, 0));
       // Vector
    }
}
