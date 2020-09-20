package leetcode.tag.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制组合枚举
 * 递归法
 * 字典序法
 */
public class P216_combinationSum3_2 {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n){
        dfs(1, 9, k, n);
        return ans;
    }

    public void dfs(int cur, int n, int k, int sum){

    }
}
