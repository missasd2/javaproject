package exam.bole;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    public static String sixToThree (String sixString) {
        // write code here
        int n = sixString.length();
        int i = n - 1;
        int j = 0;
        int num = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        while(i > 1) {
            //num += Integer.parseInt(sixString.charAt(i) - 'A' + 10 +"") * Math.pow(16, j);
            num += map.get(sixString.charAt(i)) * Math.pow(16, j);
            i--;
            j++;
        }
        //
        int a = num;
        int b = 0;
        if (num == 0) return "0";
        String s = new String();
        while(a > 0) {
            s = a % 3 + s;
            a = a / 3;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Problem3.sixToThree("oXA"));
    }


}
