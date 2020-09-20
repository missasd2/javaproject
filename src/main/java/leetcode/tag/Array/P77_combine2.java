package leetcode.tag.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 输出集合的所有子集
 */
public class P77_combine2 {
    // 从n
    public void dfs(int u, int state){

    }

    public static boolean helper(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] words = line.split(",");
            HashSet<String> set = new HashSet<>();
            for(String s : words){
                if(set.contains(s)){
                    return false;
                }else{
                    set.add(s);
                }
            }
        }
        return true;
    }

    // 可乐换瓶盖；共有 n 元钱， 每瓶m元，每k个瓶盖兑一瓶；
    public static int exchange(int n, int m, int k){
        // 开始不换一共能喝first瓶
        int first = n / m;
        int total = first;
        // 开始用first个盖子进行兑换
        while (first > k){
            // first个盖子能换second瓶
            int second = first / k;
            // 计入总数
            total += second;
            // 用seconde个盖子继续上述流程
            first = second;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(exchange(40, 2, 4));
        String substring = "234".substring(0, 1);
        System.out.println(substring);
    }
}
