package leetcode.tag.slidingWindow;
import java.util.HashSet;
import java.util.Set;
/**
 * P3 无重复字符的最长子串
 */
public class P3_LengthOfLongestSubString {

    public int lengthOfLongestSubString(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int ans = 0;
        // 右指针，初始值为-1
        int rk = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断的移动右指针
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
