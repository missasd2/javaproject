package exam.wanmei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 4
 *
 * 15
 *
 * 5 3 4 6
 *
 * 20 10 12 30
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 道具数量
        int size = sc.nextInt(); // 背包容量大小
        int[] pack = new int[n]; // 地面道具重量
        for (int i = 0; i < n; i++) {
            pack[i] = sc.nextInt();
        }

        int[] value = new int[n]; // 道具价值
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(pack[i], value[i]);
        }
        System.out.println(map);

        int[][] dp = new int[n+1][size + 1];
        for (int i = 0; i < n; i++) {

        }


    }


}
