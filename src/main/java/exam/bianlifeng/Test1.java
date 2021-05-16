package exam.bianlifeng;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        float numerator; // 分子
        float denominator;  // 分母
        boolean flag = false; // 是否为负数
        if (line.charAt(0) == '-') {
            flag = true;
        }
        String[] tmp = line.split("/");
        numerator = Float.parseFloat(tmp[0]);
        denominator = Float.parseFloat(tmp[1]);
        float result = numerator / denominator;



        // 去除末尾的零
        System.out.println(result);

    }
}
