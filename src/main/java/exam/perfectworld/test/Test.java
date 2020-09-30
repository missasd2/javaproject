package exam.perfectworld.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static List<Integer> helper(int[] nums, int target){
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length-1; i++){
            for (int j = i; j < nums.length-1; j++){
                if (nums[j] > nums[j+1]){
                    i = j;
                    res.add(j);
                }
            }
        }
        return res;
    }

    // res = [4, 7, 9]
    public static int search(int[] nums, List<Integer> res, int target){
        int result = -1;
        if (res.size() == 0){
            result = Arrays.binarySearch(nums, target);
            return result;
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {15 ,16 ,19 ,20, 25, 1, 3, 4, 5, 7 ,10 ,14};
        System.out.println(helper(nums, 0)); // 4 ，对应的是25
        Arrays.sort(nums);
        for (int i:
             nums) {
            System.out.printf(i + " ");
        }
    }


}
