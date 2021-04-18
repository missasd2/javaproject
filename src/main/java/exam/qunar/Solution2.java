package exam.qunar;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 11 3 7 123abcd0000
 *
 */
public class Solution2 {

    static List<String> getAll(int length, int start, int end, String input) {
        List<String> list = new ArrayList<>();

        if (length < end - start) {
            return list;
        }
        String str1 = input.substring(0, start);
        String str2 = input.substring(start, end);
        String str3 = input.substring(end, input.length());
        int n = end - start;
        // 得到str2的变体
        // 得到str2的变体
        int i = (1 << n) - 1;
        System.out.println(i);
        while (i >= 0){
            list.add(str1 + getStr2(str2, i) + str3 + "\n");
            i--;
        }

        //list.add(str1 + getStr2(str2, 1 << n - 1) + str3);
        return list;
    }

    private static String getStr2(String str2, int mask){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if ((mask & 1 << i) != 0) {
                builder.append(Character.toUpperCase(str2.charAt(i)));
            } else {
                builder.append(Character.toLowerCase(str2.charAt(i)));
            }
        }
        return builder.toString();
    }
//
    public static void main(String[] args) {
       // System.out.println(1 << 2);
        System.out.println(getAll(11, 3, 7, "123abcd0000"));
        //System.out.println(getAll(11, 3, 7 , "123abcd0000").size());
        System.out.println(getStr2("abcd", 0000));
        System.out.println("abcd".substring(0, 2));
    }
}