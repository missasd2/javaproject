package exam.langchao.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 被砍掉的树
 * 时间限制： 3000MS
 * 内存限制： 655360KB
 * 题目描述：
 * 某条街道两侧分别种植了一排树木，并按如下编号：
 *
 * 1 3 5 7 .... 45 47 49 ... 99
 *
 * 2 4 6 8 ... 46 48 50 ... 100
 *
 * 但是有一些树被砍去，希望你能找出一边最长的连续的大树。
 *
 *
 *
 * 输入描述
 * 第一行一个整数N
 *
 * 第二行N个整数表示被砍去树的编号
 *
 * 输出描述
 * M 和 X（表示从第M棵大树开始，共有连续的X棵大树，如果有多个解，输出M最小的解即可）
 *
 *
 * 样例输入
 * 5
 * 9 15 27 35 6
 * 样例输出
 * 8 47
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 存储奇数行
        List<Integer> odd = new ArrayList<>();
        // 存储偶数行
        List<Integer> even = new ArrayList<>();

        for (int i = 0; i < N; i++){
            int tmp = sc.nextInt();
            if (tmp %2 == 0){
                even.add(tmp);
            }else {
                odd.add(tmp);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
    }


    // 计算偶数行
    private int[] helper_odd(List<Integer> even){
        int len = even.size();
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 50;
        int first = 0;
        int second = 100;
        for (int i : even){

        }
        return res;
    }
}
