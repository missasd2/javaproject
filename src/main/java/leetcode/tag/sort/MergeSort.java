package leetcode.tag.sort;

import java.util.Arrays;

public class MergeSort {

    public static void Merge(int[] nums, int left, int mid, int right){
        /**
         *
         * left 为原数组左半部分的指针
         *
         * r1 为原数组右半部分的指针
         *
         *
         */
        int[] tmp = new int[nums.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && r1 <= right){
            if (nums[left] <= nums[r1]){
                tmp[tIndex++] = nums[left++];
            }else {
                tmp[tIndex++] = nums[r1++];
            }
        }

        // 将左边剩余的归并
        while (left <= mid){
            tmp[tIndex++] = nums[left++];
        }
        // 将右边剩余的归并
        while ( r1 <= right){
            tmp[tIndex++] = nums[r1++];
        }

        // 从临时数组拷贝到原数组
        while (cIndex <= right){
            nums[cIndex] = tmp[cIndex];
            cIndex++;
        }

    }

    // 分治法，先递归的将数组等分，然后返回的时候，对每个调用使用merge函数
    private static void Sort(int[] a, int left, int right){
        if (left >= right) return;

        int mid = (left + right) / 2;
        Sort(a, left, mid);
        Sort(a, mid, right);
        Merge(a, left, mid, right);
    }



    public static void main(String[] args) {
        int[] nums = {8,7,6,5,4,3,0};
        MergeSort.Sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));

    }
}
