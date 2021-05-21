package leetcode.tag.bit;

import java.util.*;

public class P1738_kthLargestValue_1 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m+1][n+1];

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i-1][j] ^ pre[i][j-1] ^ pre[i-1][j-1] ^ matrix[i-1][j-1];
                result.add(pre[i][j]);
            }
        }

        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        return result.get(k - 1);
    }

    public static void main(String[] args) {

    }
}
