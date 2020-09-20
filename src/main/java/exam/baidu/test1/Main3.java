package exam.baidu.test1;

import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(firstMissingPositive(arr));
        }
    }

    public static int firstMissingPositive(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0){
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i+1;
            }
        }
        return n +1;
    }
}
