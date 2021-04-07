package leetcode.tag.unionfindSet;

/**
 *  1.5.2.7 加权 quick-union 算法
 */
public class WeightedQuickUnionUF {

    private int[] id; // 父链接数组 （由触点索引）
    private int[] sz;  // 由触点索引的）各个根节点所对应的分量的大小
    private int count; // 连通分量的大小

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = i;
        }
    }

    // 返回连通分量的数量
    public int count(){return count;}

    // 判断p和q是否在同一个分量中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // 返回p所在分量的标识符
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }
    public int find_re(int p) {
        if (id[p] != p){
            id[p] = find(id[p]);
        }
        return id[p];
    }

    //
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        // 将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }


}
