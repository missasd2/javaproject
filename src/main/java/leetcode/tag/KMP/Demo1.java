package leetcode.tag.KMP;

/**
 * 问题：字符串匹配
 * 如果给定文本串S“BBC ABCDAB ABCDABCDABDE”，和模式串P“ABCDABD”，
 * 现在要拿模式串P去跟文本串S匹配，要查找P在S中的位置
 *
 * 方法一：暴力法
 * 假设现在文本串S匹配到 i 位置，模式串P匹配到 j 位置，则有：
 *
 * 如果当前字符匹配成功（即S[i] == P[j]），则i++，j++，继续匹配下一个字符；
 * 如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0。
 * 相当于每次匹配失败时，i 回溯，j 被置为0。
 */
public class Demo1 {

    public static int BruteForce(String s, String p){
        int sLen = s.length();
        int pLen = p.length();

        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen){
            // 如果当前字符匹配，则i++, j++
            if (s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == pLen){
            return i - j;
        }
        return -1;
    }

    // KMP算法，它利用之前已经部分匹配这个有效信息，保持i 不回溯，
    // 通过修改j 的位置，让模式串尽量地移动到有效的位置。

    public static void main(String[] args) {
        String s = "BBCABCDABABCDABCDABDE";
        String p = "ABCDABA";
        System.out.println(BruteForce(s, p));
    }
}
