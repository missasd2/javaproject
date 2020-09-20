package exam.guanglianda.test1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();


        int count = 0;
        while ((a+b+c+d) / 4 != 0){
            long temp = (a+b+c+d) / 4;
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

    private static boolean check(long a, long b, long c, long d){
        long[] ans = {a, b, c, d};
        ArrayList<Long> positive = new ArrayList<>();
        long negative = 0;
        for (long i : ans){
            if (i > 0) positive.add(i);
            if (i < 0) negative += i;
        }

        int[] res = new int[positive.size()];
        for (int i=0; i < positive.size(); i++){
            if (positive.get(i) % 2 != 0) return false;
           negative = negative + positive.get(i) / 2;
        }
        // if (negative != 0) return false;
        return true;
    }
}
