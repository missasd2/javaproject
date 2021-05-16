package leetcode.tag.greedy;

import java.util.HashMap;
import java.util.Map;

public class P13_roman2Int {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int roman2Int(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i+1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
