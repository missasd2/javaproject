package HlighParallel.chp5.p8;

import java.util.List;

public class CommonSort {
    // 冒泡排序
    public static void bubbleSort(int[] nums){
        for (int i = nums.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1])
                exch(nums, j, j+1);
            }
        }
    }




    // 奇偶交换排序
    public static void oddEvenSort(int[] nums){
        // 用来记录当前迭代是否发生了数据交换,1表示上一次比较交换发生了数据交换
        int exchFlag = 1;
        // start变量用来表示是奇交换还是偶交换，start为0表示进行偶交换
        int start = 0;
        while (exchFlag == 1 || start == 1){
            exchFlag = 0;
            for (int i = start; i < nums.length-1; i+=2) {
                if (nums[i] > nums[i+1]){
                    exch(nums, i, i+1);
                    exchFlag = 1;
                }
            }
            // 每次迭代结束后，切换start的状态
            if (start == 0)
                start = 1;
            else
                start = 0;
        }
    }

    private static void exch (int[]nums, int pre, int next){
        int temp = nums[next];
        nums[next] = nums[pre];
        nums[pre] = next;
    }

    public static void main(String[] args) {
        int[] nums = {52,5, 7, 4, 3, 1};

//        CommonSort.bubbleSort(nums);
        CommonSort.oddEvenSort(nums);
        for (int i: nums) {
            System.out.print(i+ " ");
        }
    }
}
