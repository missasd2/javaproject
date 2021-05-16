package leetcode.tag.dp.back;

/**
 * n: 物品数量
 * w[i]: 第i件物品的重量
 * v[i]: 第i件物品的价值
 * c：背包容量
 */
public class ZeroOneBackPack {
    private int n = 7;
    private int[] w = {0,4,6,2,2,5,1};
    private int[] v = {0,8,10,6,3,7,2};
    int c = 12;

    public int maxValue(int n, int[] w, int v, int c) {

        for (int i = 1; i <=n; i++) {

        }
        return -1;
    }
    public static void help() {
        int[] dp = new int[5];
        for (int n : dp) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        help();
    }
}
