package leetcode.tag.Array;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;

/**
 * 求1，2，3 的全排列
 */
public class DFS_1 {

    public void  dfs (char[] p, boolean[] pb, int level, ArrayList<Character> result){
        // 1. basecae
        if (level == p.length+1){
            for (int i=0; i<result.size(); i++){
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;


        }
        // 2. 遍历候选节点
        for (int i = 0; i <p.length; i++){

            char c = p[i];
            // 2.1 筛选
            if (!pb[i]){
               result.add(c);
               pb[i] = true;
               dfs(p, pb, level+1, result);
               // 将pb[i]恢复到修改前的状态
                result.remove(result.size()-1);
               pb[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[] p = {'A', 'B', 'C'};
        ArrayList<Character> result = new ArrayList<>();
        boolean[] pb = new boolean[p.length];
        int level = 1;
        DFS_1 dfs_1 = new DFS_1();
        dfs_1.dfs(p, pb, level, result);
    }

}
