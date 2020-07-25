package leetcode.tag.DP;

import org.w3c.dom.ls.LSOutput;

/**
 * 509. 斐波那契数
 * 重叠子问题
 */
public class P509_Fib {
    public static int fib(int N){
        // N = 1, N=2 的时候就直接返回了
        if (N == 1 || N ==2) return 1;
        return fib(N-1) + fib(N-2);
    }

    public static void main(String[] args) {
        System.out.println(P509_Fib.fib(3));
    }
}
