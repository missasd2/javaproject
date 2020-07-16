package leetcode.tag.DP;

public class LongestPalindrome_dp2 {
    public String longestPalindrome(String  s){
        int len = s.length();
        if (len < 2) return s;

        // 初始化
        boolean[][] dp= new boolean[len][len];
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true; // 单个字符组成的子数组必定是回文的
        }

        //
        for ( int j = 1; j < len; j++){
            for ( int i = 0; i < j; i++){
                if (chars[i] != chars[j]) dp[i][j] = false;
                else {
                    if ( j - i < 3) dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if ( dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }

            }



        }
        return s.substring(begin, begin+maxLen);

    }
}
