package leetcode.tag.dp;

/**
 * P115  不同的子序列
 */
public class P115_MinDistinct {

    public  int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        // 边界情况
        if (m < n)  return 0;
        // 二维数组 dp[i][j] 表示在 s[i:]的子序列中 t[j:]出现的个数。
        int[][] dp = new int[m + 1][n + 1];
        // 边界情况
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        // i = m时，为边界情况，因此i 循环从 m - 1开始。
        for (int i = m - 1; i >= 0 ; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0 ; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        P115_MinDistinct solution = new P115_MinDistinct();
        String s = "babgbag";
        String t = "bag";
        System.out.println(solution.numDistinct(s, t));
    }

}
