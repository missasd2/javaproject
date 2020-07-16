package leetcode.tag.DP;

public class LongestPalindrome_dp1 {
    public String longestPalindrome(String  s){
        int len = s.length();
        // 若字符串长度小于2，则一定是回文串
        if (len < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // 初始化状态数组
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();

        // 3. 状态转移
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 若头尾字符不相等，则为false
                if (chars[i] != chars[j]) dp[i][j] = false;
                else {
                    // 若头尾字符相等，进行进一步判断
                    if ( j - i < 3) dp[i][j] = true;
                    else {
                        // 状态转移方程中的最简单情况。
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                // 更新最长子序列的起始索引
                if ( dp[i][j] && j-i+1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }

        }
        return s.substring(begin, begin+maxLen);

    }
}
