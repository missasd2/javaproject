package leetcode.tag.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * P421_数组中两个数的最大异或值
 */
public class P421_findMaximumXOR {
    // 最高位的二进制位编号为30

    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for(int k = HIGH_BIT; k >= 0; k--) {
            Set<Integer> seen = new HashSet<>();
            // 将所有的pre^k(a_j) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第k个二进制位为止的部分
                // 只需将其右移k位
                seen.add(num >> k);
            }

            // 目前x包含从最高位开始到第k+1个二进制位为止的部分
            // 我们将 x 的第k个二进制位置为1，即为 x = x*2+1
            int xNext = x * 2 + 1;
            boolean found = false;

            // 枚举 i
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么x的第k个二进制位只能为0
                // 即为 x = x*2
                x = xNext - 1;
            }
        }
        return x;
    }
}