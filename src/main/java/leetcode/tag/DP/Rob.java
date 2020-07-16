package leetcode.tag.DP;

public class Rob {
    public static int rob(int[] nums){
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        int [] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        int max = 0;
//        for (int i = 2; i < nums.length; i++){
//            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
//        }
//        return dp[nums.length-1];

        // 考虑使用滚动数组
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) return nums[0];

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;

    }

    public static void main(String[] args) {
        int [] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
        System.out.println(5/2);
    }

}
