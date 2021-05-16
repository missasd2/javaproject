package leetcode.tag.sort.quickSort;

/**
 * 核心思想：
 *          找基准点
 *          基准点归位
 * 时间复杂度：
 *          平均时间复杂度为O(nlogn), 最差为O(n^2)
 * 排序稳定性；
 *          不稳定排序
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        int i,j,temp,t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        // temp 就是基准位
        temp = arr[low];

        while ( i < j ) {
            // 先看右边
            while (temp <= arr[j] && i < j) {
                j--;
            }
            // 再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            // 如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        // 最后将基准位的值 与 i和j相等位置的数字 交换
        arr[low] = arr[i];
        arr[i] = temp;
        // 递归调用左半数组
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }
}
