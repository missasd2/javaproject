package leetcode.tag.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * P781 森林中的兔子
 */
public class P781_NumRabbits {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int c : answers) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int y = entry.getKey();
            int x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        P781_NumRabbits solution = new P781_NumRabbits();
        int[] answers = {10, 10, 10};
        System.out.println(solution.numRabbits(answers));
    }
}
