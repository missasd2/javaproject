package leetcode.tag.dfs.grid;

public class P695_maxAreaOfIsland1 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    res = Math.max(res, area(grid, i, j));
                }
            }
        }
        return res;
    }

    // 1. area()函数的作用返回面积
    public int area(int[][] grid, int r, int c){
        /**
         * 2. basecase
         * 为null
         * 越界
         * 被访问过
         */
        if (grid == null) return 0;
        if (!check(grid, c, r)) return 0;
        if (grid[r][c] != 1) return 0;


        /**
         * 3. 函数等价关系
         */
        // 把 将要访问的格子涂色，表示已经访问
        grid[r][c] = 2;
        return 1
                + area(grid, r-1, c)
                + area(grid, r+1, c)
                + area(grid, r, c-1)
                + area(grid, r, c+1);
    }

    // 判断是否越界
    private boolean check(int[][] grid, int r, int c){
        if (c < 0 || c >= grid[0].length) return false;
        return r >= 0 && r < grid.length;
    }
}
