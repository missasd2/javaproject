package leetcode.tag.array;

/**
 * P31 下一个排列
 */
public class P31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后向前查找第一个顺序对（i,i+1）
        // 满足a[i]  < a[i+1]
        // 较小数为a[i]; 则[i+1， n）为下降序列
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // 从区间[i+1， n）中从后向前查找第一个元素j
            // 满足a[i] < a[j]
            // 较大数为a[j]
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换a[i]与a[j]
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 双指针反转区间
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        P31_NextPermutation solution = new P31_NextPermutation();
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
    }
}
