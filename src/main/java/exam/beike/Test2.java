package exam.beike;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 7
 * 4 9 7 7 3 3 2
 *
 * 9
 * 2 10 3 9 2 5 3 2 9
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 大饼数量
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count = Math.max(count, entry.getValue());
        }
        System.out.println(count);
    }
}
