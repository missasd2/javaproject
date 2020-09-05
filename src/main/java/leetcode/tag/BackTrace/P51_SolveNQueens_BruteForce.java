package leetcode.tag.BackTrace;

import java.util.*;

public class P51_SolveNQueens_BruteForce {
    public List<List<String>> solveNQueens(int n) {
        // 用来表示每个可行解
        char[][] chess = new char[n][n];
        // 初始化数组
        Arrays.fill(chess, '.');
        // 用来保存所有可行解
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] chess, int row){

        if (row == chess.length){
            res.add(construct(chess));
            return;
        }
        // 遍历每一列
        // 并按行进行递归
        for (int col = 0; col < chess.length; col++){
            if (isValid(chess, row, col)){
                // 数组复制一份
                char[][] temp = copy(chess);
                temp[row][col] = 'Q';
                solve(res, temp, row+1);
            }
        }
    }



    private char[][] copy(char[][] chess){
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
    }

    // row表示第几行，col表示第几列
    private boolean isValid(char[][] chess, int row, int col){
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagnosals1 = new HashSet<>();
        Set<Integer> diagnosals2 = new HashSet<>();
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] == 'Q'){
                    // 将此列索引加入
                    columns.add(j);
                    // 左下到右上
                    diagnosals1.add(i+j);
                    // 左上到右下
                    diagnosals2.add(j - i);
                }
            }
        }
        // 行肯定不会冲突，需检测列
        if (columns.contains(col) || diagnosals1.contains(row+col) || diagnosals2.contains(col - row)){
            return false;
        }
        return true;
    }


    // 将二维char数组转化为list，list的每个元素都是由char[][]每行字符组成的字符串
    private List<String> construct(char[][] chess){
        List<String> path = new ArrayList<>();
        for (int i=0; i < chess.length; i++){
            path.add(new String(chess[i]));
        }
        return path;
    }

}
