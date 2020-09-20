package DaimaZhinan.chp4.p1;

/**
 * 斐波那契数列——对数时间复杂度
 */
public class Fibonacci_1 {

    public static int f(int N){

        return 1;
    }

    /**
     * 暴力递归-时间复杂度O(2^N)
     * @param N
     * @return
     */
    public static int brute_recur(int N){
        if (N <= 0) return 0;
        if (N <= 2) return 1;

        return brute_recur(N-1) + brute_recur(N-2);
    }

    /**
     * 递归，时间复杂度为O(N)
     * @param N
     * @return
     */
    public static int dp_for(int N){
        int pre = 1;
        int cur = 1;
        if (N < 0) return pre;
        if (N <= 2) return pre;
        while (N >= 3){
            int tmp = pre + cur;
            pre = cur;
            cur = tmp;
            --N;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(brute_recur(3));
        System.out.println(dp_for(4));
    }
}
