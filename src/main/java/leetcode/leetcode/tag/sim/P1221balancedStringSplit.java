package leetcode.leetcode.tag.sim;

import javax.xml.bind.SchemaOutputResolver;

public class P1221balancedStringSplit {

    public static int balancedStringSplit(String s) {
        int n = s.length();
        int flag = 0;
        int counter = 0;
        if(n <= 1) {
            return counter;
        }

        if(s.charAt(0) == 'L') {
            flag = 1;
        } else {
            flag = -1;
        }

        int i = 1;

        while(i < n) {

            while(flag != 0 && i < n) {
                if(s.charAt(i) == 'L') {
                    flag++;
                } else {
                    flag--;
                }
                i++;
            }
            System.out.println(i);
            counter++;
            i++;
        }

        return counter;

    }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }
}
