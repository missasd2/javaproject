package leetcode.tag.DP;

public class MaxSubArray {
    public static int maxSubArray(int[] nums){
//        int pre = 0;
//        int maxAns = nums[0];
//        for (int num: nums) {
//            pre = Math.max(pre + num, num);
//            maxAns = Math.max(maxAns, pre);
//
//        }
//        return maxAns;
        int max = nums[0];
        int preMaxSub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preMaxSub > 0) {
                preMaxSub += nums[i];
            } else {
                preMaxSub = nums[i];
            }
            if (preMaxSub > max) {
                max = preMaxSub;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(MaxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
