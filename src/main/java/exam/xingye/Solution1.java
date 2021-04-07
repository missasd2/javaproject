package exam.xingye;

import java.util.Locale;

public class Solution1 {
    public String changeFormatNumber (String number) {
        int n = number.length();
        boolean flag = false; // 负数标志位
        // 1. 判断是否为负数
        if (number.charAt(0) == '-') {
            flag = true;
        } else {
            flag = false;
        }

        // 2. 确定数字的所在索引
        int start = flag ? 1 : 0;
        int end = n - 1;

        // 3. 非数字字符判断
        int count = 0; // 10 的 权值
        long sum = 0;
        for (int i = end; i >= start; i--){
            char tmp = number.charAt(i);
            if ((int)tmp < (int)'0' || (int)tmp > (int)'9'){
                return "INPUTERROR";
            }
            //4. 计算所代表的十进制数
            sum += Integer.parseInt(tmp+"") * Math.pow(10, count++);
            // 5. 判断是否越界
            if (sum > Integer.MAX_VALUE) return "NODATA";
        }

        // 转换成二进制
        StringBuilder res = new StringBuilder(new String("0"));
        long a = sum;
        long b = 0;
        while (a != 0) {
            b = a % 2;
            a = a / 2;
            res.insert(0, b);
        }

        if (res.length() > 15) return "NODATA";

        // 输出二进制
        if (flag) {
            sum = -sum;
            String binary = Integer.toBinaryString((int)sum);
            String hex = Integer.toHexString((int)sum).toUpperCase();
//            int b_len = binary.length();
//            int h_len = hex.length();
            return helper(binary, hex, flag);
            //return binary + "," + hex;
        } else {
            String binary = Integer.toBinaryString((int)sum);
            String hex = Integer.toHexString((int)sum).toUpperCase();
            return helper(binary, hex, flag);
            //return binary + "," + hex;
        }

    }

    private String helper(String binary, String hex, boolean flag) {
        int b_len = 16 - binary.length();
        int h_len = 4 - hex.length();
        StringBuilder bBuilder = new StringBuilder(binary);
        StringBuilder hBuilder = new StringBuilder(hex);
        int tmp = flag ? 1 : 0;
        while (b_len > 0) {
            bBuilder.insert(tmp, "0");
            b_len--;
        }
        binary = bBuilder.toString();
        while (h_len > 0) {
            hBuilder.insert(tmp, "0");
            h_len--;
        }
        hex = hBuilder.toString();
        return binary + "," + hex;
    }

    public static void main(String[] args) {
        //System.out.println((int)'A');
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.changeFormatNumber("-1"));

    }
}
