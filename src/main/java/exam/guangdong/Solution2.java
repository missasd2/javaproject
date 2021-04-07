package exam.guangdong;

import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean ans = validate(num);
        if(ans) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    public static boolean validate(int num) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i <= 9; i++){
            map.put(i, i*i*i);
        }
        int a = num / 100;
        int b = (num % 100) / 10;
        int c = num - a * 100 - b * 10;

        if(map.get(c) > num || map.get(b) > num || map.get(a) > num ) return false;
        if(map.get(a) + map.get(b) + map.get(c) == num) return true;
        return false;
    }
}
