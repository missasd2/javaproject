package leetcode.tag.backtrack;

import java.util.*;

/**
 * 基于集合的回溯
 */
public class P51_SolveNQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>(); // 记录每一列上是否有皇后
        Set<Integer> diagonals1 = new HashSet<Integer>(); // 记录左至右斜线上是否有皇后
        Set<Integer> diagonals2 = new HashSet<Integer>(); // 记录右至左斜线上是否有皇后
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions,
                          int[] queens, int n, int row,
                          Set<Integer> columns, Set<Integer> diagonals1,
                          Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generatedBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i; // 左至右斜线
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i; // 右至左斜线
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i; // 表示row行i列，放置有棋子
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                backtrack(solutions,
                        queens, n, row+1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);

            }
        }
    }

    public List<String> generatedBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';  // row数组表示 表示i行 queens[i]列 上应该放置皇后
            board.add(new String(row));
        }
        return board;
    }
}
