package leetcode.tag.Array;

import java.util.List;

public class P77_combine {
    public List<List<Integer>> combine(int n, int k) {
        return null;
    }

    // 位运算
    public static void main(String[] args) {
        System.out.println(1 << 1);
        System.out.println(-1 << 1);
        // 按位与 （返回的是对应十进制数）
        System.out.println(1&2); // 0
        System.out.println(5 & 3); // 1
        System.out.println(6 & 7); // 110 & 111 结果位110即十进制的6
        System.out.println(13 & 1); // 1
        // 按位或 101 | 010 = 111 返回十进制7；
        System.out.println(5 | 2);
        // 按位异或 101 ^ 100 = 001 返回十进制1；相异返回1，相同返回0
        System.out.println(5 ^ 4);
        // 按位取反
        System.out.println(~15);
        System.out.println("=====================");
        // 移位运算
        System.out.println(-1<<2);
        System.out.println("==========");

        // mod运算（取余运算）
        // x mod p = x - p * (x/p向下取整)
        int x = -2;
        int y = 10;
        int p = 12;
        int mo1 = (int)(x - p * Math.ceil(x/p));
        int mo2 = (int)(y - p * Math.ceil(y/p));
        System.out.println(mo1);
        System.out.println(mo2);
        System.out.println("=====================");

        int[] nums = {1, 2, 3};
        int n = 3;
        int s = 13;
        for (int i=0; i < 4; i++){
            if ( (13 & 1<<i) != 0){
                System.out.println(i);
            }

        }

    }

}
