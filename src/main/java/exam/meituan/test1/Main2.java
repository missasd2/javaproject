package exam.meituan.test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 小美的跑腿代购
 * 时间限制： 5000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美的一个兼职是美团的一名跑腿代购员，她有n个订单可以接，订单编号是1~n，但是因为订单的时效性，他只能选择其中m个订单接取，精明的小美当然希望自己总的获利是最大的，已知，一份订单会提供以下信息，跑腿价格v，商品重量w kg，商品每重1kg，代购费用要加2元，而一份订单可以赚到的钱是跑腿价格和重量加价之和。小美可是开兰博基尼送货的人，所以自然不会在意自己会累这种事情。请问小美应该选择哪些订单，使得自己获得的钱最多。
 *
 * 请你按照选择的订单编号的从小到大顺序，如果存在多种方案，输出订单编号字典序较小的方案。
 *
 *
 *
 * 输入描述
 * 输入第一行包含两个正整数n，m，表示订单的数量和小美可以接的订单数量(1<=n,m<=10000)
 *
 * 接下来有n行，第i行表示i-1号订单的信息。每行有两个正整数v和w ，表示一个订单的跑腿价格和商品重量。(1<=v,w<=1000)
 *
 * 输出描述
 * 输出包含m个1~n之间的正整数，中间用空格隔开，表示选择的订单编号
 * 样例输入
 * 5 2
 * 5 10
 * 8 9
 * 1 4
 * 7 9
 * 6 10
 * 样例输出
 * 2 5
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入第一行包含两个正整数n，m，
        // 表示订单的数量和小美可以接的订单数量
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 存储价格
        int[] order = new int[n];
        // 存储序号
        int[] num = new int[n];
        // 接下来有n行，第i行表示i-1号订单的信息。
        // 每行有两个正整数v和w ，表示一个订单的跑腿价格和商品重量。
        // (1<=v,w<=1000)
        // 初始化n个订单的价格
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            order[i] = v + w * 2;
            num[i] = i+1;
        }

        // 同时对order，num进行冒泡排序
        for (int j = num.length - 1; j > 0 ; j--) {
            for (int i = 0; i < j; i++){
                if (order[i] < order[i+1]){
                    exch(i, i+1, order);
                    exch(i, i+1, num);
                }
            }
        }

        //
        int[] result = Arrays.copyOf(num, m);
        Arrays.sort(result);
        for (int a : result){
            System.out.print(a + " ");
        }


    }

    private static void exch(int n, int m, int[] nums){
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}
