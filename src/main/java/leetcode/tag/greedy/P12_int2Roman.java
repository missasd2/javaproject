package leetcode.tag.greedy;

public class P12_int2Roman {
    public static String intToRoman(int num) {
        int[] nums = {1000, 500, 100, 50, 10, 5, 1};
        String[] roman = {"M", "D", "C", "L", "X", "V", "I"};

        StringBuffer buffer = new StringBuffer();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            String symbol = roman[i];
            while ( num >= value) {
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
        System.out.println(intToRoman(num));
    }
}
