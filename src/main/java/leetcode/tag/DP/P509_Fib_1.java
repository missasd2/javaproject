package leetcode.tag.DP;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 509. 斐波那契数
 *  重叠子问题：状态压缩
 *  状态转移方程：dp(i) = dp(i-1) + dp(i-2)
 *  最优子结构
 */
public class P509_Fib_1 {

    public  int fib(int N){
        int pre = 1;
        int cur = 1;
        int temp = 0;
        if (N <= 0) return 0;
        if ( N == 1 || N == 2) return 1;
        for (int i=3; i <= N; i++){
            temp = pre+cur;
            pre = cur;
            cur = temp;
        }
        return cur;
    }




    public static void main(String[] args) {

        P509_Fib_1 fib_1 = new P509_Fib_1();
        System.out.println(fib_1.fib(3));
    }
}
