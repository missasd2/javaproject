package leetcode.tag.io;

import java.util.Scanner;

public class AcmIOTemplate {

    // 输入是已知大小的二维数组
    public static void template_1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 定义需要的阶层数n
        int[][]array = new int[n][n];
        System.out.println("输入数组的各个元素： ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

    public static void template_2(){
        Scanner sc = new Scanner(System.in);
        // 总共有T组数据
        int T = sc.nextInt();
        while (T > 0){
            T--; // 为了保证输出
            int[] a = new int[10000];
            int[] b = new int[10000];
            // 每组数据的第一行:n, 表示每行有n个正整数
            int n = sc.nextInt();
            // 每组数据的第二行：，有n个整数
            for (int i = 1; i <= n ; i++) {
                a[i] = sc.nextInt();
            }
            // 每组数据的第三行：有n个整数；
            for (int i = 1; i <= n ; i++) {
                b[i] = sc.nextInt();
            }
        }

    }

    public static void main(String[] args) {

    }
}
