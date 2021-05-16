package cs.os.ThreadSync;

import JavaSE.extend.B;

/**
 * 进程同步之：银行家算法
 *
 */
public class Banker {
    public static final int N = 4; // 进程数目
    public static final int M = 3; // 资源类别数
    public static int[] Resource = { 9, 3, 6 }; // 不同种类资源具有的数量
    //
    public static int[][] Claim = { {3, 2, 2}, {6, 1, 3}, {3, 1, 4}, {4, 2, 2}};

    public static int[][] Allocate = new int[N][M];

    // Need[i][j] = k: 表明进程i还需要Rj类资源 数量为k，方能完成任务
    public static int[][] Need = { {3, 2, 2}, {6, 1, 3}, {3, 1, 4}, {4, 2, 2}};

    // Available[i] = k: 表明Ri类资源k个
    public static int[] Available = { 9, 3, 6 };
    public int[][] state = new int[N][M];

    public static void main(String[] args) {
        Banker ban = new Banker();
    }


    




}
