package leetcode.tag.algo.sort;

public class QuickSort1 {

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high){
            return;
        }
        i = low;
        j = high;
        temp = arr[low]; // 选取最低位为基准值

        while (i < j) {
            while ( temp <= arr[j] && i < j ) {
                j--;
            }
            while ( temp >= arr[i] && i < j ) {
                i++;
            }

            if (i < j) { //如果满足条件，则交换
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        // 最后将基准值 与 i和j相等的位置处的数字进行交换
        arr[low] = arr[i];
        arr[i] = temp;
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
