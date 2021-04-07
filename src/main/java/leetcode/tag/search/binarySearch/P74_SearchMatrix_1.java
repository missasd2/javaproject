package leetcode.tag.search.binarySearch;

/**
 * P74 搜索矩阵
 * 直接削减整行、整列
 */
public class P74_SearchMatrix_1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P74_SearchMatrix_1 solution = new P74_SearchMatrix_1();
        int[][] matrix = {{1,3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target  = 1;
        System.out.println(solution.searchMatrix(matrix, 1));

    }
}
