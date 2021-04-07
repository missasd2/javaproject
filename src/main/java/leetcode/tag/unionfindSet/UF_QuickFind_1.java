package leetcode.tag.unionfindSet;

/**
 * 1.5.2.1 quick-find 算法
 */
public class UF_QuickFind_1 {
    private int[] id; // 分量id
    private int count; // 分量数量

    public UF_QuickFind_1(int N) {
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
        return id[p];
    }

    // 在p和q之间添加一条连接
    // 总的事件复杂度为 O（N2）
    public void union(int p, int q) {
        // 将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        // 如果p和q已经在相同的分量中则不需要采取任何动作
        if (pID == qID) return;

        // 将p的分量重命名为q的名称。将p归到q下
        // 访问次数在N+1 到 2N + 1 之间
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
            count--;
        }
    }

    // 1.5.2.3 quick-union算法
    private int find_1_5_2_3(int p) {
        // 找出分量的名称
        // 相当于一直向它的父节点 上溯。直到到达根节点，根节点的父节点定义为自己
        while(p != id[p]) p = id[p];
        return p;
    }
    public void quick_union_1_5_2_3(int p, int q) {
        // 将p和q的根节点统一
        int pRoot = find_1_5_2_3(p);
        int qRoot = find_1_5_2_3(q);
        if (pRoot == qRoot) return;

        // 将p归到q下
        id[pRoot] = qRoot;

        count--;
    }



}
