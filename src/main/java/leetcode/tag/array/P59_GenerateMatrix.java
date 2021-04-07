package leetcode.tag.array;

/**
 * P59 生成螺旋矩阵
 */
public class P59_GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] order = new int[n][n];
        if (n == 0) return order;

        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = n;
        int columns = n;
        int row = 0;
        int column = 0;
        int total = n * n;
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            order[row][column] = i+1;
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || visited[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
