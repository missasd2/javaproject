package leetcode.tag.array;

public class P59_GenerateMatrix_level {

    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1;
        int tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom
            r--;
            for (int i = r; i >= 1; i--) mat[b][i] = num++; // right to left
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top
            l++;
        }
        return mat;
    }
}
