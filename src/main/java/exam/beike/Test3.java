package exam.beike;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 序列长度
        int k = sc.nextInt(); // 比较的基准值
        int[] a = new int[n];
        int flag = 0; // 标志位; 表明大于基准值的个数 减去  小于等于基准值的个数 的差。
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > k) {
                flag++;
            }else {
                flag--;
            }
        }
        int result = 0;

        int low = 0;
        int high = n-1;
        while (high != low && flag > 0) {
            if (a[low] <= k) {
                low++;
                flag++;
            }
            if (a[high] <= k) {
                high--;
                flag++;
            }
        }
        System.out.println(result);
    }
}
