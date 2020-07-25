package algs4.chp1.p1;

public class Search {

    // 2. 二分查找
    public static int binarySearch(int[] nums, int target){
        int i = 0;
        int j = nums.length-1;
        while ( i <= j){
            int mid = (i + j)/2;
            if (nums[mid] == target) return nums[mid];
            if (nums[mid] > target) j = mid-1;
            if (nums[mid] < target) i = mid + 1;
        }
        return -1;
    }

    // 3. 插值查找——递归版,此处返回的是目标值的索引
    public static int insertionSearch(int[] nums, int target, int low, int high ){
        int mid = low + (target - nums[low])/(nums[high] - nums[low])*(high-low);
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) return insertionSearch(nums, target, low, mid-1);
        if (nums[mid] < target) return insertionSearch(nums, target, mid+1, high);
        return -1;
    }

    // 插值查找——非递归版
    public static int insertSearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while (low < high){
            int mid = low + (target - nums[low])/(nums[high] - nums[low])*(high - low);
            if (nums[mid] == target) return mid;
            if (nums[mid] > target ) high = mid - 1;
            if (nums[mid] < target) low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10,12,23, 30};
        int[] nums1 = {1};
        int target = 6;
        System.out.println(Search.binarySearch(nums, target));
        System.out.println(Search.binarySearch(nums1, target));
        System.out.println(Search.insertionSearch(nums, target, 0, nums.length-1));
        System.out.println(Search.insertSearch(nums, target));
    }
}
