package SwordToOffer.chp1.p1.q1;

/**
 * 对斐波那契数列进行改进：使用dp table
 */
public class Fibonacci_DpTable {
    public int fib(int n){
        int[] dp_table = new int[n+1];
        dp_table[0] = 0;
        dp_table[1] = 1;
        dp_table[2] = 1;
        if (n <= 2) return dp_table[n];
        for (int i=3; i<n+1; i++){
            dp_table[i] = dp_table[i-2] + dp_table[i-1];
        }
        return dp_table[n];
    }

    public static void main(String[] args) {
        Fibonacci_DpTable fibonacci_dpTable = new Fibonacci_DpTable();
        System.out.println(fibonacci_dpTable.fib(3));

    }

}
