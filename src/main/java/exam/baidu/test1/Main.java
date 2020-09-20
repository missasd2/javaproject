package exam.baidu.test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++){
                for (int k = 0; k < m; k++){
                    grid[i][k] = sc.nextInt();
                }
            }
            if (grid == null || grid.length == 0) {
                System.out.println(0);
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;

            for (int r = 0; r < nr; r++) {
                for (int c = 0; c < nc; c++) {
                    if (grid[r][c] == 1){
                        ++num_islands;
                        DFS(grid, r, c);
                    }
                }
            }
            System.out.println(num_islands);
        }
    }

    public static void DFS(int[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r>=nr || c >= nc || grid[r][c] == 0){
            return;
        }
        grid[r][c] = 0;
        DFS(grid, r-1, c);
        DFS(grid, r+1, c);
        DFS(grid, r, c-1);
        DFS(grid, r, c+1);
    }

}
