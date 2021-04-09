package leetcode.tag.search.binarySearch;

/**
 * P33 搜索旋转有序数组
 */
public class P33_Search_RotatedSorted_I {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1; // 定义双指针
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 1. 左子数组有序
            if (nums[0] <= nums[mid]) {
                // 1.1 如果在左子数组，则缩小范围
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                    // 1.2 如果不在左子数组，则一定在右子数组中
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
