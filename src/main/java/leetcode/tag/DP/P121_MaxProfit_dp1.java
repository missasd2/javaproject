package leetcode.tag.DP;

/**
 * 最佳买卖股票时机
 */
public class P121_MaxProfit_dp1 {
    public int maxProfit(int[] prices){
        if (prices.length <= 1) return 0;
        int[] diff = new int[prices.length-1];
        for (int i = 0; i < prices.length-1; i++) {
            diff[i] = prices[i+1] - prices[i];
            System.out.println(diff[i]);

        }
        int[] dp = new int[diff.length];
        dp[0] = Math.max(0, diff[0]);
        int profit = dp[0];
        for (int j = 1; j < diff.length; j++) {
            dp[j] = Math.max(0, dp[j-1] + diff[j]);
            profit = Math.max(profit, dp[j]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        P121_MaxProfit_dp1 p121_maxProfit = new P121_MaxProfit_dp1();
        System.out.println(p121_maxProfit.maxProfit(prices));


    }
}
