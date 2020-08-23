package exam.iqiyi.test1;

import java.util.HashSet;
import java.util.Scanner;
/**
 *判断路径是否相交
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 *
 *
 * 输入描述
 * 一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *
 * 输出描述
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 *
 * 样例输入
 * ESSWNEE
 * 样例输出
 * True
 * */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        if(check(path)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }


    }

    private static boolean check(String path){
        if(path == null || path.length() == 0) return false;
        int x = 0;
        int y = 0;
        HashSet<String> set = new HashSet<>();
        set.add(x+" "+y);
        for(int i = 0; i<path.length(); i++){
            char c = path.charAt(i);
            if(c == 'N'){
                y++;
            }
            if(c == 'S'){
                y--;
            }
            if(c == 'W'){
                x--;
            }
            if(c == 'E'){
                x++;
            }
            if(!set.add(x+" "+y)){
                return true;
            }
        }
        return false;
    }
}
