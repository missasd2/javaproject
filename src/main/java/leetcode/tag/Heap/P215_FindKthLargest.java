package leetcode.tag.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P215_FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums){
            heap.offer(num);
        }
        System.out.println(heap);

        int result=0;

        for (int i = 0; i < k; i++){
            result = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }
}
