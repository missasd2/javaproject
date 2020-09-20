package leetcode.tag.Array;

public class DFSPermutationGenerator {
    public int N;
    private boolean[] used;
    private int[] result;

    public DFSPermutationGenerator(int n){
        N = n;
        // used 数组共有N位， 分别对应N个数的信息。
        // 每当访问一个结点时，
        // 就将它的值所对应的 used 数组的那一位设置为已经使用。
        // 当该结点的所有孩子结点都遍历结束，就把它的 used 信息清除，
        // 并且回溯到上一级结点。
        used = new boolean[n + 1];
        result = new int[n];
    }

    public static void main(String[] args) {
        DFSPermutationGenerator generator = new DFSPermutationGenerator(4);
        generator.make(0);
    }

    public void make(int level){
        for (int i = 1; i <= N ; i++) {
            if (!used[i]){
                used[i] = true;
                result[level] = i;
                make(level + 1);
                used[i] = false;
            }
        }

        // 根节点为第零层，当到达N-1层时即叶子节点时；（相当于basecase）
        if (level == N - 1){
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
