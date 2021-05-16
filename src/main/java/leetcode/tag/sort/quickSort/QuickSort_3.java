package leetcode.tag.sort.quickSort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class QuickSort_3 {

    public static void quickSort(int[] arr, int low, int high) {
        int i,j,temp,t;

        if (low > high) {
            return;
        }

        i = low;
        j = high;
        temp = arr[low];


        while ( i < j ) {
            while ( temp <= arr[j] && i < j ) {
                j--;
            }

            while ( temp >= arr[i] && i < j ) {
                i++;
            }

            // 如果符合条件，则交换i, j位置的值
            if ( i < j ) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        // 交换基准值和i, j 相等位置的值
        arr[low] = arr[j];
        arr[j] = temp;
        // 递归左子数组
        quickSort(arr, low, j - 1);
        quickSort(arr, j+1, high);
    }
    
    public double sum (double a , double b) {
        return a + b;
    }

    public void readFile(String filePath) throws FileNotFoundException {

    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }
}
