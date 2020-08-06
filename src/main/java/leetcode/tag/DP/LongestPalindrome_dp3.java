package leetcode.tag.DP;

public class LongestPalindrome_dp3 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxlen = 0;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] =true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1 > maxlen){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+ maxlen);
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindrome_dp3 dp3 = new LongestPalindrome_dp3();
        System.out.println(dp3.longestPalindrome(s));
    }
}
