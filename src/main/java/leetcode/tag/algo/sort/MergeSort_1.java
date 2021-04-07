package leetcode.tag.algo.sort;

public class MergeSort_1 {

    // 将数组递归二分
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    // 将子数组进行合并
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 升序排列
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 若左侧子数组有剩余，进行拷贝
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 若右侧子数组有剩余，进行拷贝
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 将temp中元素全部拷贝到原数组中
        for (int p = 0; p < temp.length; p++) {
            arr[p + left] = temp[p];
        }

    }
    public static void main(String[] args) {
        int[] test= {9, 2, 6, 3, 5, 7, 10, 11};
        mergeSort(test, 0, test.length - 1);
        for (int j : test) {
            System.out.print(j + ", ");
        }
    }

}
