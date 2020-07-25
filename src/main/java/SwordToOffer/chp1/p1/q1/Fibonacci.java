package SwordToOffer.chp1.p1.q1;

public class Fibonacci {
    public int fib(int n){
        int[] m = new int[n+1];
        return helper(n, m);
    }

    private int helper(int n, int[] m){
        // 带备忘录的递归解法
        if (n <= 0) return m[0];
        // 已经计算过
        if (n == 1 || n == 2){
            m[n] = 1;
            return m[n];
        }
        if (m[n] != 0){
            return m[n];
        }
        m[n] = helper(n-1, m) + helper(n-2, m);
        return m[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(3));
    }
}
