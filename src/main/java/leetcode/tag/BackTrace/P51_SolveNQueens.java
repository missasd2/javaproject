package leetcode.tag.BackTrace;

import java.util.*;

public class P51_SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        // 记录每行放置的皇后的列下标
        int[] queens = new int[n];
        Arrays.fill(queens, -1);;
        // 记录每一列是否有皇后
        Set<Integer> columns = new HashSet<Integer>();
        // 下面两个集合用于记录两个方向的每条斜线上是否有皇后
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer>diagonals1, Set<Integer>diagonals2){
        // 已经到达最后一行的情况
        if (row == n){
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        }else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)){
                    continue;
                }
                // 如果都通过以上条件的检测则证明没有冲突，则落子
                // 更新用于检测冲突的集合
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                //
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n){
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
