package leetcode.tag.unionfindSet;

/**
 * P721 accountMerge
 */
public class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 将index2 归到 index1下
    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = index;
        }
        return parent[index];
    }
}
