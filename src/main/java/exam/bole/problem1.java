package exam.bole;

import java.util.PriorityQueue;

public class problem1 {


    public int second (int[] arr) {
        // write code here
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int x : arr) {
            heap.add(x);
        }
        heap.poll();
        return heap.poll();
    }
}
