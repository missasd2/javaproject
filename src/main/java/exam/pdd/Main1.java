package exam.pdd;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();  // 有T个case
        // 每个case中表示的 细胞总数
        List<String> sum = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            //sum.add(in.nextInt());
            //sum.add(Integer.toBinaryString(in.nextInt()));
            String tmp = Integer.toBinaryString(in.nextInt());
            sum.add(tmp.length()+"");
            sum.add(binaryToResult(tmp));
//            System.out.println(tmp.length());
//            System.out.println();
        }

        for (String s : sum) {
            System.out.println(s);
        }

    }

    private static String binaryToResult(String str) {
        StringBuilder builder = new StringBuilder();
        int n = str.length();
        int j = 1;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') {
                builder.append(j + " ");
            }
            j++;
        }
        String tmp = builder.toString();
        return tmp.substring(0, tmp.length()-1);
    }
}
