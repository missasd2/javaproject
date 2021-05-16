package exam.bianlifeng;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int i = input.indexOf('#');
        String first = input.substring(0, i);
        String second = input.substring(i+1, input.length());
        // 趟数
        Integer packNums = Integer.parseInt(second);
        String[] nums = first.split(",");
        // 包裹序列
        int[] pack = new int[nums.length];

        int max = 0; // 最大包裹的重量
        int total = 0; // 所有包裹总重量
        int average = total / pack.length;

        for (int j = 0; j < nums.length; j++) {
            pack[j] = Integer.parseInt(nums[j]);
            max = Math.max(pack[j], max);
            total += pack[j];
        }

        int result =  binarySearch(pack, average, max, packNums);
    }

    private static int binarySearch(int[] pack, int average, int max, int packNums) {
        int low = average;
        int high = max;
        while (low < high) {
            int mid = (low + high) / 2;
            
        }

        return -1;
    }
}
