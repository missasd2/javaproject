package leetcode.tag.Array;

import java.util.ArrayList;
import java.util.List;

public class P216_combinationSum3 {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 最多有1 << 9 种情况；
        for (int mask = 0; mask < (1 << 9); ++mask){
            // 对每种情况进行检查
            if (check(mask, k, n)){
                ans.add(new ArrayList<Integer>(temp));
            }
        }
        return ans;
    }

    /**
     * 判断一个数字mask其二进制标识是否满足
     * 1. 二进制位中1的个数为k
     * 2. 二进制位1所映射选取的数组中的数字累加和为n
     * 如果满足则返回true，否则返回false
     * @param mask
     * @param k
     * @param n
     * @return
     */
    public boolean check(int mask, int k, int n){
        temp.clear();
        for (int i = 0; i < 9; i++){
            if ( ((1 << i) & mask) != 0){
                temp.add(i+1);
            }
        }
        if (temp.size() != k) return false;
        int sum = 0;
        for (int num : temp) sum += num;
        return sum == n;
    }
}
