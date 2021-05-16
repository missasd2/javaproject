package leetcode.tag.sort.quickSort;

public class QuckSort_1 {

    public static void quickSort(int[] arr, int low, int high) {
        int i,j,temp,t;
        if ( low > high) {
            return;
        }

        i = low;
        j = high;
        temp = arr[low]; // 基准值

        while ( i < j ) {

            while ( temp <= arr[j] && i < j) {
                j--;
            }

            while ( temp >= arr[i] && i < j) {
                i++;
            }

            // 如果满足条件则交换
            if ( i < j ) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        // 最后将基准位与i j 相等位置进行交换
        arr[low] = arr[i];
        arr[i] = temp;

        // 递归调用左半数组
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);

    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }
}
