package leetcode.tag.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P554_leastBricks {

    public static int leastBricks(List<List<Integer>> wall) {
        int m = wall.size();
        int sum = 0; // 一行的长度
        for(int i : wall.get(0)) {
            sum += i;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++ ) {
            List<Integer> wall_row = wall.get(i);
            int total = 0;
            for(int len : wall_row) {
                total += len;
                map.put(total, map.getOrDefault(total, 0) + 1);
            }
        }
        int max_count = 0;
        map.remove(sum);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max_count = Math.max(max_count, entry.getValue());
        }
        return m - max_count;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        ArrayList<Integer> tmp1 = new ArrayList<>();
        tmp1.add(1);
        tmp1.add(2);
        tmp1.add(2);
        tmp1.add(1);
        wall.add(tmp1);
        ArrayList<Integer> tmp2 = new ArrayList<>();
        tmp2.add(3);
        tmp2.add(1);
        tmp2.add(2);
        wall.add(tmp2);
        ArrayList<Integer> tmp3 = new ArrayList<>();
        tmp3.add(1);
        tmp3.add(3);
        tmp3.add(2);
        wall.add(tmp3);
        ArrayList<Integer> tmp4 = new ArrayList<>();
        tmp4.add(2);
        tmp4.add(4);
        wall.add(tmp4);
        ArrayList<Integer> tmp5 = new ArrayList<>();
        tmp5.add(3);
        tmp5.add(1);
        tmp5.add(2);
        wall.add(tmp5);
        ArrayList<Integer> tmp6 = new ArrayList<>();
        tmp6.add(1);
        tmp6.add(3);
        tmp6.add(1);
        tmp6.add(1);
        wall.add(tmp6);
        System.out.println(leastBricks(wall));
    }
}
