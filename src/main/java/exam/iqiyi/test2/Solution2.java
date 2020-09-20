package exam.iqiyi.test2;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {

            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * sliding window
     * @param s
     * @return
     */
    public static int maxLength(String s){
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                count = Math.max(count, j-i);
            }else {
                i = j;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Thread t = new Thread(){
            @Override
            public void run() {
                pong();
            }
        };
        t.start();
        System.out.println("ping");
    }

    static void pong(){
        System.out.println("pong");
    }
}
