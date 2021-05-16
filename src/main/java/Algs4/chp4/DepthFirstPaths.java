package Algs4.chp4;

import java.util.Stack;

/**
 * 算法4.1 使用深度优先搜索查找图中的路径
 * edgeTo[w]=v 表示v-w 是第一次访问w时经过的边
 * edgeTo[] 数组是一颗用父链接表示的以s为根且含有所有与s连通的顶点的树
 */
public class DepthFirstPaths {
    private boolean[] marked; // 记录这个顶点上是否调用过dfs()
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    // 假设从v开始深度遍历
    // marked数组表示已访问过v节点
    // 对于v的所有邻接点，进行迭代
    // 如果该邻接点没有访问过，则
    // 将到达该点w的 第一个点设置为v，递归操作
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        return path;
    }
}
