package leetcode.tag.BackTrace;

/**
 * 面试题 08.12. 八皇后
 * Queen[n]: 将第n个皇后放在格子的（n, Queen[n]）位置
 * judge(int n):判断（n, Queen[n]）位置是否可以放皇后
 */
public class P0812_SolveNQueens {
    // 定义皇后的个数
    static int queennum = 8;
    static int[] Queen = new int[queennum];
    // 最后满足条件的次数
    static int count = 0;
    //
    public static void NQueen(int n){
        // 放置第n行皇后
        for (int i = 0; i < queennum; i++) {
            // 皇后的位置进行赋值
            Queen[n] = i;
            // 判断是否能放置皇后

        }
    }

}
