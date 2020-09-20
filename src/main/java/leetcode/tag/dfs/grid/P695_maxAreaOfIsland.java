package leetcode.tag.dfs.grid;

public class P695_maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i =0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    res = Math.max(res, area(grid, i, j));
                }
            }
        }
        return res;
    }

    private int area(int[][] grid, int r, int c){
        // base case

        if (!check(grid, r, c)) return 0;
        if (grid[r][c] != 1) return 0;
        grid[r][c] = 2;
        return 1
                + area(grid, r-1, c)
                + area(grid, r+1, c)
                + area(grid, r, c-1)
                + area(grid, r, c+1);
    }

    // 判断是否在网格中
    private boolean check(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length) return false;
        if (c < 0 || c >= grid[0].length) return false;
        return true;
    }
}
