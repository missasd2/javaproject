package leetcode.tag.Array;

/**
 * 26. 删除排序数组中的重复项
 * 双指针法
 */
public class P26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 0;
        for(int j =0; j<nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
                count++;
            }
            continue;
        }
        return count;
    }
}
