package leetcode.tag.Graph;

import java.util.*;

public class P1042_GardenNoAdj {

    public static int[] gardenNoAdj(int N, int[][] paths) {
        // 使用map保存节点与邻接点的关系
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }

        /* 初始化路径信息 */
        for (int[] path: paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 定义返回结果数组
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            // 定义数组，用于记录已使用的颜色
            boolean[] used = new boolean[5];
            /* 查看当前节点的所有邻接点的色彩 */
            for (int adj : graph.get(i)){
                // 将这个邻接点的颜色使用情况标记下来
                used[res[adj]] = true;
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]){
                    res[i] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] paths = new int[][]{{1,2}, {2,3}, {3,1}};
        int[] result = gardenNoAdj(N, paths);
        System.out.println(Arrays.toString(result));

    }
}
