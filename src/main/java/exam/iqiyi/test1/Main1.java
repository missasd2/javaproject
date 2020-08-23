package exam.iqiyi.test1;

import java.util.Scanner;

/**
 * n的阶乘问题
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 正整数n的阶乘(n!)中的末尾有多少个0?
 *
 * 例如：n = 5, n! = 120.末尾有1个0
 *
 * 实现：int CountZero(int n);
 *
 *
 *
 * 输入描述
 * 一个正整数
 *
 * 输出描述
 * 一个自然数
 *
 *
 * 样例输入
 * 31
 * 样例输出
 * 7
 */
public class Main1 {
    public static void main(String[] args) {
//        int N = 31;
//        int num = 0;
//        for (int i = 1; i <= N ; i++) {
//            int j = i;
//            while (j%5 == 0){
//                num++;
//                j /= 5;
//            }
//        }
//        System.out.println(num);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        for (int i=1; i<=N; i++){
            result += calc(i);
        }
        System.out.println(result);
    }

    private static int count(int N){
        int count = 0;
        for (int i = 1; i <= N ; i++) {
            int j = i;
            while (j %5 == 0){
                count++;
                j = j / 5;
            }
        }
        return count;
    }

    private static int calc(int n){
        int count = 0;
        while (n%5 == 0){
            count++;
            n = n / 5;
        }
        return count;
    }
}
