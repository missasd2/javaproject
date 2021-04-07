package leetcode.tag.dp;

public class P115_MinDistinct_1 {

    public static int minDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        // 边界情况
        if (m < n) return 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >=0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        P115_MinDistinct_1 solution = new P115_MinDistinct_1();
        String s = "babgbag";
        String t = "bag";
        System.out.println(P115_MinDistinct_1.minDistinct(s, t));

    }
}
