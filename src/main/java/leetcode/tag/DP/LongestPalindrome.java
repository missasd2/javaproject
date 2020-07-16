package leetcode.tag.DP;

public class LongestPalindrome {
    public String longestPalindrome(String  s){
        int len = s.length();
        // 特判
        if (len < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // 1. 状态定义
        // dp[i][j]表示s[i...j]是否是回文串

        // 2. 初始化
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        // 3. 状态转移
        //
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j] ){
                    dp[i][j] = false;
                }else {
                    //
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
