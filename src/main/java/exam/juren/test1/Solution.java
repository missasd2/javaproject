package exam.juren.test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int[] smallerNumbersThanCurrent (int[] nums) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        for (int i = nums.length-1; i >= 0; i--){
            map.put(tmp[i], i);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            result[i] = map.get(nums[i]);
        }
        return result;
    }

    public static int getResult (int[] data) {
        // write code here
        // 判断升序
        if (data.length <= 2) return 0;

        // 判断升序
        int up = data[0];
        int count_up = 0;
        for (int i = 1; i < data.length; i++){
            if (data[i] < data[i-1]){
                data[i-1] = data[i];
                count_up++;
            }
        }
        // 判断降序
        int down = data[0];
        int count_down = 0;
        for (int i = 1; i < data.length; i++){
            if (data[i] > data[i-1]){
                data[i-1] = data[i];
                count_down++;
            }
        }
        return Math.max(count_down, count_up);



    }

    public static void main(String[] args) {
//        int[] tmp = {6,5,4,8,6};
//        int[] result = smallerNumbersThanCurrent(tmp);
//        for (int i = 0; i < result.length; i++ ) {
//            System.out.printf(" " + result[i]);
//        }
        int[] tmp = {3, 1, 4, 2, 8};
        System.out.println(getResult(tmp));
    }
}
