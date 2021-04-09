package leetcode.tag.search.binarySearch;

/**
 * P154 搜索旋转排序数组 III
 */
public class P154_Search_RotatedSorted_III {

    public static int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            }else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,4};
        System.out.println(P154_Search_RotatedSorted_III.findMin(nums));
    }
}
