package exam.guanglianda.test1;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int count = 0;
        while ((a+b+c+d) / 4 != 0){
            int temp = (a+b+c+d) / 4;
            a = a-temp;
            b = b-temp;
            c = c-temp;
            d = d-temp;
            count += temp;
        }
        System.out.println(a + "" + b + "" + c + "" + d);
        if (!check(a, b, c ,d)){
            System.out.println(-1);
        }else{
            System.out.println(count * 4);
        }
    }

    private static boolean check(int a, int b, int c, int d){
        int[] ans = {a, b, c, d};
        ArrayList<Integer> positive = new ArrayList<>();
        int negative = 0;
        for (int i : ans){
            if (i > 0) positive.add(i);
            if (i < 0) negative += i;
        }

        int[] res = new int[positive.size()];
        for (int i=0; i < positive.size(); i++){
            if (positive.get(i) % 2 != 0) return false;
           negative = negative + positive.get(i) / 2;
        }
        if (negative != 0) return false;
        return true;
    }
}
