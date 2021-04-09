package leetcode.tag.dp.back;

public class BackPack {

    /**
     *
     * @param m: 背包总重量
     * @param V: 价值数组
     * @param W: 重量数组
     * @return
     */
    public static int backpack_01_I(int m, int[] V, int[] W) {
        int[] dp = new int[m + 1];

        for (int i = 0; i < V.length; i++) {
            for (int j = m; j >= 0; j--) {
                dp[j] = Math.max(dp[j], j - W[i] >= 0 ? dp[j - W[i]] + V[i] : 0);
            }
        }
        return dp[m];
    }

    /**
     *
     * @param m: 表示总重量
     * @param V：价值序列
     * @param W：重量序列
     * @return
     */
    public static int backpack_01_II(int m, int[] V, int[] W) {
        int[][] dp = new int[V.length + 1][m + 1];
        // dp[i][j] 表示 前i件物品放入容量为j的背包，所能获得的最大价值
        for (int i = 0; i <= V.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (W[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[W.length][m];
    }

    public static void main(String[] args) {
        int[] V = {20, 10, 12, 30};
        int[] W = {5, 3, 4, 6};
        System.out.println(backpack_01_I(15, V, W));
        System.out.println(backpack_01_II(15, V, W));


    }
}
