package leetcode.tag.array;

public class P31_NextPermutation_1 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // 从后往前递归，确保是降序序列
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 从后半部分的降序序列中，找到第一个大于nums[i]这个较小数的
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 利用双指针反转序列
        reverse(nums, i+1);
    }

    public static void swap(int[] nums ,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums ,int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void prinNum(int[] nums) {
        for (int num : nums) {
            System.out.printf("%d, ", num);

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        P31_NextPermutation_1 solution = new P31_NextPermutation_1();
        solution.nextPermutation(nums);
        prinNum(nums);
//        reverse(nums, 0);
//        prinNum(nums);

    }
}
