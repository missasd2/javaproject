package leetcode.tag.DP;

/**
 * 最佳买卖股票时机
 */
public class P121_MaxProfit {
    public int maxProfit(int[] prices){
        int buy = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{2, 5, 1, 3};
        P121_MaxProfit p121_maxProfit = new P121_MaxProfit();
        System.out.println(p121_maxProfit.maxProfit(prices));
    }
}
