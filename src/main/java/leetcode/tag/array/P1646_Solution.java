package leetcode.tag.array;

import java.util.Arrays;

public class P1646_Solution {

    public static int getMaximumGenerated(int n) {
        if(n <= 1) return n;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[(i - 1)/2] + nums[(i - 1)/2 + 1];
            }
        }

        return Arrays.stream(nums).max().getAsInt();



    }

    public static void main(String[] args) {
        System.out.println(P1646_Solution.getMaximumGenerated(15));
    }
}
