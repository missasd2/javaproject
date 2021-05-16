package leetcode.tag.greedy;

/**
 *   int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
 *     String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
 *

 */
public class P12_int2Roman_1 {

    public static String int2String(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer buffer = new StringBuffer();

        int n = values.length;

        for (int i = 0; i < n; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                buffer.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        int num = 100;
        System.out.println(P12_int2Roman_1.int2String(num));
    }
}
