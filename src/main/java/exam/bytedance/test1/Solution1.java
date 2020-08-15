package exam.bytedance.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static String parse(String str){
        char[] ch = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        String result = str;
        for (char c:ch){
            list.add(c);
        }
        if (ch.length < 3) return str;
        if (ch.length == 3 ){
            if (ch[0] == ch[1] && ch[1] == ch[2]){
                return str.substring(0, 2);
            }else {
                return str;
            }
        }
        for (int i=0; i<ch.length-4; i++){
            char temp = list.get(i);
            boolean flag = true;
            for (int j=i; j< i+4; j++){
                if (temp == ch[j] && flag){
                    flag = true;

                }else {
                    flag = false;
                }
            }
            if (flag){
                list.remove(i+3);
            }
        }

        return list.toString();
    }

    public static void main(String[] args) {
        String str = "wooooooow";
        Solution1 solution1 = new Solution1();
        System.out.println(Solution1.parse(str));
    }
}
