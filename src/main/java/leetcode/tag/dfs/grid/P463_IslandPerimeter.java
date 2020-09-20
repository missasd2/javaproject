package leetcode.tag.dfs.grid;

/**
 * 463. 岛屿的周长
 */
public class P463_IslandPerimeter {

    public int islandPerimeter(int[][] grid){
        int res = 0;
        for (int i=0; i< grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    res += area(grid, i, j);
                }
            }
        }
        return res;
    }

    // 函数作用返回岛屿的周长,边缘的长度
    public int area(int[][] grid, int r, int c){

        // basecase,越界，已被访问
        if (!check(grid, r, c)) return 1;
        if (grid[r][c] == 0) return 1;
        if (grid[r][c] != 1) return 0;


        grid[r][c] = 2;

        // 函数递推式
        return area(grid, r, c-1)
                + area(grid, r, c+1)
                + area(grid, r-1, c)
                + area(grid, r+1, c);

    }


    private boolean check(int[][] grid, int r, int c){
        if (r < 0 || r >= grid.length) return false;
        return c>=0 && c < grid[0].length;

    }
}
