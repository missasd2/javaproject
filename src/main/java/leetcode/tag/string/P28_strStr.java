package leetcode.tag.string;

public class P28_strStr {
    public int strStr(String ss, String pp) {
        // KMP算法
        // ss: 原串， pp：匹配串
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从1开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建next数组,数组长度为匹配串的长度 （next数组是和匹配串相关的）
        int[] next = new int[m+1];
        // 构造过程 i = 2, j = 0 开始，i小于等于匹配串长度 [构造i从2开始]
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话,j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话, 先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i], 结束本次循环, i++
            next[i] = j;
        }

        // 匹配过程，i = 1, j = 0开始，i 小于等于原串长度 【匹配 i从1开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j+1]) j = next[j];
            // 匹配成功的话, 先让 j++, 结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功， 直接返回下标
            if (j == m) return i - m;
        }
        return -1;
    }

    public int strStr_1(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String ss = "abeababeabf";
        String pp = "abeabf";
        P28_strStr solution = new P28_strStr();
        System.out.println(solution.strStr(ss, pp));
    }
}
