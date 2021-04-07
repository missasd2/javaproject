package leetcode.tag.unionfindSet;

/**
 * 算法第四版
 * 1.5 union-find 的实现
 */
public class UF {
    private int[] id; // 分量id
    private int count; // 分量数量

    public UF(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // 计算连通分量的数量
    public int count() {
        return count;
    }

    // 判断p和q是否在同一个分量中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    // 返回p （0到N-1） 所在的分量的标识符
    public int find(int p){
        return -1;
    }

    // 在p和q之间添加一条连接
    public void union(int p, int q) {

    }
}
