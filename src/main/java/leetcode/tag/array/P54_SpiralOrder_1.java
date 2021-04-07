package leetcode.tag.array;

import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

public class P54_SpiralOrder_1 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0) return order;
        int rows = matrix.length, columns = matrix[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int total = rows * columns;
        boolean[][] visited = new boolean[rows][columns];
        int directionIndex = 0;
        int rowIndex = 0, columnIndex = 0;

        for (int i = 0; i < total; i++) {
            order.add(matrix[rowIndex][columnIndex]);
            visited[rowIndex][columnIndex] = true;
            int nextRow = rowIndex + directions[directionIndex][0];
            int nextColumn = columnIndex + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            rowIndex += directions[directionIndex][0];
            columnIndex += directions[directionIndex][1];

        }
        return order;
    }

    public List<Integer> spiralOrder_1(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int total = rows * columns;
        boolean[][] visited = new boolean[rows][columns];
        int row = 0;
        int column = 0;
        int directionIndex = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public List<Integer> spiralOrder_level(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom){
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        P54_SpiralOrder_1 solution = new P54_SpiralOrder_1();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(matrix));

        System.out.println(solution.spiralOrder_1(matrix));
        System.out.println(solution.spiralOrder_level(matrix));
    }
}
