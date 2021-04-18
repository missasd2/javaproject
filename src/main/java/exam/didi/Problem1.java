package exam.didi;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 树木的数量
        int x = sc.nextInt(); // 公差
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        
        int[] dp = new int[n + 1];
        dp[1] = a[1] - a[0] == x? 0 : 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + (a[i - 1] - a[i - 2] == x ? 0 : 1);
            a[i - 1] = a[i - 2] + x;
        }
        System.out.println(dp[n]);
    }


}
