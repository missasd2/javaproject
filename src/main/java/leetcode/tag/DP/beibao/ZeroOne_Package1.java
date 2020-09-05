package leetcode.tag.DP.beibao;

import java.util.Scanner;

public class ZeroOne_Package1 {
    public static void main(String[] args) {

        /**
         * 接收参数
         */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int number = sc.nextInt(); // 物品的数量

            int[] weight = new int[number + 1];
            int[] value = new int[number + 1];

            weight[0] = 0;
            for (int i = 1; i < number + 1; i++) {
                weight[i] = sc.nextInt();
            }

            value[0] = 0;
            for (int i = 1; i < number + 1 ; i++) {
                value[i] = sc.nextInt();
            }

            int capacity = sc.nextInt(); // 背包容量

            // 处理0-1 背包问题
            // 其中v[i][j] 对应于：当前有i个物品可选，
            // 并且当前背包的容量为j时，我们能得到的最大值
            int[][] v = new int[number + 1][ capacity + 1];

            // 填动态规划表。当前有i个物品可选，并且当前背包的容量为j。
            for (int i = 0; i < number + 1; i++) {
                for (int j = 0; j < capacity + 1; j++) {
                    if (i == 0){
                        // 边界情况：若只有0道题目可以选做，
                        // 那只能得到0分。所以令V(0,j)=0
                        v[i][j] = 0;
                    }
                    if (j == 0){
                        // 边界情况：若只有0分钟的考试时间，
                        // 那也只能得0分。所以令V(i,0)=0
                        v[i][j] = 0;
                    }else {
                        if (j < weight[i]){
                            // 包的容量比当前物品体积小，装不下；
                            v[i][j] = v[i - 1][j];
                        } else {
                            v[i][j] = Math.max(v[i - 1][j], v[i-1][j - weight[i]] + value[i]);
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("动态规划表如下：");
            for (int i = 0; i < number + 1; i++) {
                for (int j = 0; j < number + 1; j++) {
                    System.out.println(v[i][j] + "\t");
                }
                System.out.println();
            }

        }


    }
}
