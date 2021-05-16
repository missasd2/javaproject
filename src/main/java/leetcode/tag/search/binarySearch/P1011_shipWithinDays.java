package leetcode.tag.search.binarySearch;

import java.util.Arrays;

/**
 * P1011 在 D 天内送达包裹的能力
 *
 *  二分查找转化为判定问题
 */
public class P1011_shipWithinDays {

    public static int shipWithinDays(int[] weights, int D) {

        // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1;
            int cur = 0;
            for(int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if ( need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(P1011_shipWithinDays.shipWithinDays(weights, D));
    }
}
