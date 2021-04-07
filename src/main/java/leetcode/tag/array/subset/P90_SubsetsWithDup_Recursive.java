package leetcode.tag.array.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归法 实现二进制枚举子集
 * 枚举 enumeration
 */
public class P90_SubsetsWithDup_Recursive {

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            // 因为Java是按值传递，引用型变量的值为 对象的引用
            ans.add(new ArrayList<>(t));
            return;
        }
        //
        dfs(false, cur + 1, nums);
        // 剪枝
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        // 将元素加入集合
        t.add(nums[cur]);
        // 前一个选了，
        dfs(true, cur + 1, nums);
        // 回溯
        t.remove(t.size() - 1);
    }

    public static void main(String[] args) {
        P90_SubsetsWithDup_Recursive solution = new P90_SubsetsWithDup_Recursive();
        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }
}
