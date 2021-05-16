package leetcode.tag.dp;

public class P740_DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for(int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = second;
            second = Math.max(second, first + nums[i]);
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        P740_DeleteAndEarn solution = new P740_DeleteAndEarn();
        int[] nums = {2,2,3,3,3,4};
        System.out.println(solution.deleteAndEarn(nums));
    }
}
