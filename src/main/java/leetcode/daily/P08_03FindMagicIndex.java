package leetcode.daily;

public class P08_03FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int mid = 0;
        int result = Integer.MAX_VALUE;
        while(i < j){
            mid = (i + j)/2;
            if(nums[mid] == mid){
                result = Math.min(result, mid);
                j = mid;
//                continue;
            }
            if(nums[mid] < mid){
                i = mid+1;
            }
            if(nums[mid] > mid){
                j = mid - 1;
            }
        }
        if( result == Integer.MAX_VALUE) return -1;
        return result;
    }

    public static void main(String[] args) {
//        int[] nums= {0, 2, 3, 4, 5};
        int[] nums= {0, 0, 2};
        int index = new P08_03FindMagicIndex().findMagicIndex(nums);
        System.out.println(index);
    }
}
