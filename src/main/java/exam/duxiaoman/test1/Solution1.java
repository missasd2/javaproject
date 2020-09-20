package exam.duxiaoman.test1;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 北京天坛
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 北京天坛的圜丘坛为古代祭天的场所，分上、中、下三层，上层中心有一块圆形石板（称为天心石），环绕天心石砌m块扇面形石板构成第一环，向外每环依次增加m块。下一层的第一环比上一层的最后一环多m块，向外每环依次增加m块。
 *
 * 已知每层环数相同。现给出每层的环数n和每一环比上一环增加的块数为m，求总共有多少块扇面形石板？
 *
 *
 *
 * 输入描述
 * 单行输入。
 *
 * 两个正整数n和m，表示每层的环数和每一环比上一环增加的块数（n<1e5,m<1e5），两个正整数之间用空格隔开。
 *
 * 输出描述
 * 输出扇面形石板的总数。
 *
 *
 * 样例输入
 * 2 9
 * 样例输出
 * 189
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long i = sc.nextInt();
        long j = sc.nextInt();
        long k = j;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int q = 0; q < j; q++){
            queue.add(q);
        }
        long result = 0;
        for (int l = 0; l < i * 3; l++) {
            result += k;
            k += j;
        }
        System.out.println(result);
    }
}
