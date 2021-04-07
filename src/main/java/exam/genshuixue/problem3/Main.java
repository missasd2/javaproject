package exam.genshuixue.problem3;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(100, 0);
        map.put(50, 0);
        map.put(20, 0);
        map.put(10, 0);
        map.put(5, 0);
        map.put(1, 0);

        int a = n / 100;
        map.put(100, a);
        a = n - a * 100;

        int b = a / 50;
        map.put(50, b);
        b = a - b * 50;

        int c = b / 20;
        map.put(20, c);
        c = b - c * 20;

        int d = c / 10;
        map.put(10, d);
        d = c - d * 10;

        int e = d / 5;
        map.put(5, e);
        e = d - e * 5;

        int f = e;
        map.put(1, f);

        for(Integer key : map.keySet()) {
            System.out.print(key + " ");
        }
    }
}
