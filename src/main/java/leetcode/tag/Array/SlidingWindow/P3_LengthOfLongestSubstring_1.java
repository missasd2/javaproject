package leetcode.tag.Array.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class P3_LengthOfLongestSubstring_1 {
    public static int lengthOfLongestSubstring(String s){
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针
        int rk = 0;
        int ans = 0;

        // i 为左指针
        for (int i = 0; i < s.length(); i++){
            if ( i != 0){
                occ.remove(s.charAt(i-1));
            }
            while (rk < n && !occ.contains(s.charAt(rk))){
                occ.add(s.charAt(rk));
                ++rk;
            }
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
