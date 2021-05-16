package leetcode.tag.Math;

public class P633_judgeSquareSum {

    public static boolean judgeSquareSum(int n) {
        long left = 1;
        long right = (long)Math.sqrt(n);

        while ( left <= right ) {
            long sum = left * left + right * right;
            if (sum == n) {
                return true;
            } else if (sum < n) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = P633_judgeSquareSum.judgeSquareSum(355);
        System.out.println(b);
    }
}
