package leetcode.tag.DP;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P16_17_MaxSubArray {

        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            int max = -Integer.MAX_VALUE;
            dp[0] = Math.max(max, nums[0]);
            max = dp[0];
            for(int i=1; i<nums.length; i++){
                dp[i] = dp[i-1]<=0? nums[i]: dp[i-1]+nums[i];
                max = Math.max(max, dp[i]);

            }
            return max;
        }


    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {1};
        P16_17_MaxSubArray subArray = new P16_17_MaxSubArray();
        System.out.println(subArray.maxSubArray(nums));
    }
}
