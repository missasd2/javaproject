package leetcode.tag.Array.SlidingWindow;

public class P59_maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        // 初始化
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        result[0] = sum;

        for (int i = 1; i <= nums.length - k; i++){
            sum = Math.max(sum, result[i-1] - nums[i-1] + nums[i + k - 1]);
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = P59_maxSlidingWindow.maxSlidingWindow(nums, k);
        for (int i: result) {
            System.out.print(i + " ");
        }
    }
}
