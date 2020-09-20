package leetcode.tag.Array;
/**
 * 输出最长的回文子串
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        String res = helper(words);
        System.out.println(res);

    }

    private static String helper(String words){
        int len = words.length();
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }
        for(int j = 0; j < len; j++){

            for(int i = 0; i < j; i++){

                if(j-i == 1 || j-i == 2){
                    dp[i][j] = words.charAt(i) == words.charAt(j);
                }
                if (j-i > 2){
                    dp[i][j] = dp[i+1][j-1] && (words.charAt(i) == words.charAt(j));

                }
                if(dp[i][j] && (j-i+1) > right-left+1){
                    left = i;
                    right = j;
                }
            }
        }
        return words.substring(left, right+1);
    }
}
