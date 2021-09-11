package leetcode.tag.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P457_CircularArrayLoop {

    public boolean Solution(int[] nums) {
        int n = nums.length;
        int i = 0;
        int counter = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Boolean> list2 = new ArrayList<>();

        while (!list1.contains(i)) {
            list1.add(i);
            System.out.println(nums[i] + "nums " + i);
            if(nums[i] > 0) {
                list2.add(true);
            } else {
                list2.add(false);
            }
            counter++;
            i = (i + nums[i] + n) % n;
        }

        if (counter <= 1) {
            return false;
        }

        System.out.println(counter);

        for(Boolean b : list2) {
            System.out.print(b + " ");
        }


        for (int j = 0; j < counter - 1; j++) {
            if (list2.get(j) != list2.get(j+1)) {
                return false;
            }
        }

        //System.out.println(counter);

        return true;
    }

    public String reverseVowels(String s) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int n = s.length();
        int j = s.length() - 1;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] tmp = s.toCharArray();
        while(i <= j) {
            while(i < n && i <= j) {
                if(!set.contains(s.charAt(i))) {
                    i++;
                } else {
                    break;
                }

            }

            while(j >= 0 && i <= j) {
                if(!set.contains(s.charAt(j))) {
                    j--;
                }else {
                    break;
                }
            }
            swap(tmp, i, j);
        }
        return new String(tmp);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    

    public static void main(String[] args) {
        P457_CircularArrayLoop solution = new P457_CircularArrayLoop();
        int[] nums = {-1, -2, -3, -4, -5};
        System.out.println(solution.Solution(nums));

        String s = "Hello";
        System.out.println(solution.reverseVowels(s));
    }
}
