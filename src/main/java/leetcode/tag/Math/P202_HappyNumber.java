package leetcode.tag.Math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * P202 快乐数
 */
public class P202_HappyNumber {

    // 计算整数n的下一个数 （按照每位数字的平方和形式）
    public static int getNext(int n) {
        int totalSum = 0;
        while(n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    // 判断是否为快乐数
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(28));
    }
}
