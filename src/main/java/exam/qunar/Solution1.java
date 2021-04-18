package exam.qunar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 重复次数第k多的元素
 */
public class Solution1 {

    public static  int topK(int[] arrays, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 元素到次数的映射
        for (int num : arrays) {
            map.put(num, map.getOrDefault(num, 0) + 1) ;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 将次数加入堆
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry.getValue());
        }

        int i = 0;
        while (i < k -1) {
            heap.poll();
        }
        int repeats = heap.poll();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == repeats) {
                return entry.getKey();
            }
        }

        return arrays[0];


    }
}
