package leetcode.tag.array;

public class P304_numMatrixs {

    private int[][] matrix;

    public P304_numMatrixs(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++) {
            for(int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1}
        ,{1, 2, 0, 1, 5}
        ,{4, 1, 0, 1, 7}
        ,{1, 0, 3, 0, 5}
        };
        P304_numMatrixs solution = new P304_numMatrixs(matrix);
        System.out.println(solution.sumRegion(2, 1, 4, 3));

    }


}
