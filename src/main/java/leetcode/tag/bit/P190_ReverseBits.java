package leetcode.tag.bit;

public class P190_ReverseBits {

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            // n & 1 表示 取n的最后一位数字
            rev |= (n & 1) << (31 - i);
            n >>>=1; // n 逻辑右移一位
        }
        return rev;
    }

    public static void main(String[] args) {
        P190_ReverseBits solution = new P190_ReverseBits();
        System.out.println(solution.reverseBits(-1));
    }
}
