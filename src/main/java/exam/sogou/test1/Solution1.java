package exam.sogou.test1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static int getNum(){
        Scanner scanner = new Scanner(System.in);
        int a,b,c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        int[] nums = new int[3];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        Arrays.sort(nums);
        int min = nums[0];
        nums[1] = nums[1] - min;
        nums[2] = nums[2] - min;
        nums[0] = nums[0] - min;


        if(a == b && b == c) return a;
        if (nums[0] == nums[1] ) return (nums[2] - nums[0])/5 + min;
        return (nums[1] + nums[2]  ) / 4 + min;

    }

    public static void main(String[] args) {
        int num = getNum();
        System.out.println(num);
    }
}
