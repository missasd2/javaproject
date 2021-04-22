package leetcode.tag.array;

import java.util.Arrays;
import java.util.TreeSet;

public class P363_maxSumSubmatrix {

    public int maxSummatrix(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // 预处理前缀和
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = Integer.MAX_VALUE;
        // 遍历子矩阵的上边界
        for(int top = 1; top <= m; top++) {
            // 遍历子矩阵的下边界
            for (int bot = top; top <= m; bot++) {
                // 使用 有序集合 维护所有遍历到的右边界
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                // 遍历子矩阵的右边界
                for (int r = 1; r <= n; r++) {
                    // 通过前缀和计算 right
                    int right = sum[bot][r] - sum[top - 1][r];
                    // 通过二分查找 left
                    Integer left = ts.ceiling(right - k);
                    if (left != null) {
                        int cur = right - left;
                        ans = Math.max(ans, cur);
                    }
                    // 将遍历过的 rihgt加到有序集合
                    ts.add(right);
                }
            }
        }
        return ans;
    }

    // 优化
    public int maxSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        // 固定的是否为右边界
        boolean isRight = n > m;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= (isRight ? m : n); i++) {
            for (int j = i; j <= (isRight ? m : n); j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int fixed = 1; fixed <= (isRight ? n : m); fixed++) {
                    int a = isRight ? sum[j][fixed] - sum[i - 1][fixed] : sum[fixed][j] - sum[fixed][i - 1];
                    Integer b = ts.ceiling(a - k);
                    if (b != null) {
                        int cur = a - b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }

    public int maxSumSubmatrix_1(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        boolean isRight = n > m;
        int[] sum = isRight ? new int[n + 1] : new int[m + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= (isRight ? m : n); i++) {
            Arrays.fill(sum, 0);
            for (int j = i; j <= (isRight ? m : n); j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                int a = 0;
                for (int fixed = 1; fixed <= (isRight ? n : m); fixed++) {
                    sum[fixed] += isRight ? matrix[j - 1][fixed - 1] : matrix[fixed - 1][j - 1] ;
                    a += sum[fixed];
                    Integer b = ts.ceiling(a - k);
                    if (b != null) {
                        int cur = a - b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;

    }
}
