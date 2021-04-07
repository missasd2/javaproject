package leetcode.tag.array;

public class P59_GenerateMatrix_level_1 {

    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int num = 1;
        int tar = n * n;
        while (num <= tar ) {
            for (int i = l; i <= r; i++) mat[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }
}
