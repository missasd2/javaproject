package leetcode.tag.search.binarySearch;

public class P74_SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        if(matrix[0][0] > target) return false;
        if(matrix[rows - 1][cols - 1] < target) return false;

        int row = 0;
        for(int i = 0; i < rows; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][cols-1]){
                row = i; // 记录下所在行
                break;
            }
        }
        // 在本行进行二分查找
        int left = 0;
        int right = cols - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = matrix[row][mid];
            if(tmp == target) {
                return true;
            }
            if(tmp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;


    }

    public static void main(String[] args) {
        P74_SearchMatrix solution = new P74_SearchMatrix();
        int target = 10;
        int[][] matrix = {{1,3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(solution.searchMatrix(matrix, target));
    }

}

