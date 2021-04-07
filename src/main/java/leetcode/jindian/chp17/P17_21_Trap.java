package leetcode.jindian.chp17;

/**
 * 下标i处，水能到达的最大高度等于下标i两边的最大高度的最小值。
 * 下标i处，能接的水的量等于，下标i处的水能到达的最大高度减去height[i]。
 */
public class P17_21_Trap {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        // 1. 定义数组leftMax，表示下标i及其左边的位置中，height的最大高度
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 2. 定义数组rightMax, 表示下标i及其右边的位置中，height的最大高度
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
