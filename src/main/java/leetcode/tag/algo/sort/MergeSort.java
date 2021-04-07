package leetcode.tag.algo.sort;

/**
 * 归并排序：递归二分，合并排序
 */
public class MergeSort {

    public static void merSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merSort(arr, left, mid); // 左边归并排序，使得左子序列有序
            merSort(arr, mid + 1, right);
            merge(arr, left, mid, right); // 合并两个子序列
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        // 申请一个和原数组同样大小的临时数组
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            // 确保升序排列
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) { // 将左边剩余元素填入temp
            temp[k++] = arr[i++];
        }
        while (j <= right) { // 将右边剩余元素填入temp
            temp[k++] = arr[j++];
        }
        // 将temp中剩余元素拷贝到原数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }
    }

    public static void main(String[] args) {
        int[] test= {9, 2, 6, 3, 5, 7, 10, 11};
        merSort(test, 0, test.length - 1);
        for (int j : test) {
            System.out.print(j + ", ");
        }
    }
}
