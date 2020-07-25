package leetcode.tag.DP;

/**
 * 有问题
 */
public class P322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        return helper(coins, amount);

    }

    private int helper(int[] coins, int amount){
        if ( amount == 0) return 0;
        if ( amount < 0) return -1;
        int min = Integer.MAX_VALUE;
        for ( int coin : coins){
            int subproblem = helper(coins, amount-coin);
            if (subproblem == -1) continue;

        }
        return 0;

    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        P322_CoinChange change = new P322_CoinChange();
        System.out.println(change.helper(coins, amount));
    }
}
