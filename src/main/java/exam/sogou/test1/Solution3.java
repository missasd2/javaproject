package exam.sogou.test1;

import java.util.Queue;

/**
 * 普通递归需要沿着一步一步进来的函数一步一步地出去，
 * 而尾递归则可以直接回到主函数。
 */
public class Solution3 {
    // 递归
    public static int Jie_rec(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        return n * Jie_rec(n - 1);
    }
    // 尾递归
    public static int Jie_tail(int n, int m){
        if (n == 0 || n == 1) return m;
        return Jie_tail(n-1, n * m);
    }

    public static void main(String[] args) {
        System.out.println(Jie_rec(4));
        System.out.println(Jie_tail(4, 1));

    }
}

