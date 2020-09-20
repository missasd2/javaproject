package leetcode.tag.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制子集枚举
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class P216_combinationSum3_1 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<>();

    // 组合中只有1~9这九个正整数，从中选k个，满足和为n
    public List<List<Integer>> combinationSum3(int k, int n){
        // 生成所有的掩码，然后选择其中的子集
        for (int mask = 0; mask < (1 << 9); mask++){
           if (check(mask, k, n)){
               res.add(new ArrayList<>(tmp));
           }
        }
        return res;
    }

    public boolean check(int mask, int k, int n){
        tmp.clear();
        // 将掩码对应的组合中的数字加入tmp
        for (int i = 0; i < 9; i++){
            if ( (mask & (1<<i)) != 0){
                tmp.add(i+1);
            }
        }
        // 对tmp进行条件判断
        if (tmp.size() != k) return false;
        int sum = 0;
        for (int num : tmp) sum += num;
        return sum == n;
    }
}
