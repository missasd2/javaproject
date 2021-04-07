package leetcode.tag.string;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class P1047_RemoveDuplicate {

    public String removeDuplicate(String S) {
        if (S.length() <= 1) return S;
        List<Character> stack = new LinkedList<>();
        stack.add(S.charAt(0));

      return S;
    }

    private String helper(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                s = s.substring(0, i) + s.substring(i+2);
                helper(s);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String S = "abbaca";
        P1047_RemoveDuplicate solution = new P1047_RemoveDuplicate();
        System.out.println(solution.removeDuplicate(S));
    }
}
