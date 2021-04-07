package leetcode.tag.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46_Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> tmp = new LinkedList<>();
        dfs(res, tmp, visited, 0, n, nums);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> tmp, boolean[] visited, int level, int n, int[] nums) {

        if (level == n) {
            // Java 参数传递是值传递，对象类型变量在传递的时候，复制的是变量的地址。
            // 这里需将tmp做一次拷贝，否则直接res.add(tmp) 的话，由于递归回到了根节点，而tmp指向的而是同一片内存地址，为空。
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(nums[i]);
                dfs(res, tmp, visited, level+1, n, nums);
                tmp.remove(tmp.size()-1);
                visited[i] =false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

}
