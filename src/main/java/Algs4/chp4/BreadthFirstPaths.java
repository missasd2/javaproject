package Algs4.chp4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 算法4.2 使用广度优先搜索查找图中的路径
 */
public class BreadthFirstPaths {
    private boolean[] marked; // 标记是否到达过该节点
    private int[] edgeTo; // 到达该顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Deque<Integer> queue = new LinkedList<>();
        marked[s] = true; // 标记起点
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.pollFirst();
            for (int w : G.adj(v)) {
                edgeTo[w] = v;
                marked[w] = true;
                queue.offer(w);
            }
        }

    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        return stack;
    }
}
