package leetcode.tag.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * P264 第n个丑数
 */
public class P264_NthUglyNum {
    public int nthUglyNumber(int n) {

        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            // 取出堆顶元素
            long curr = heap.poll();
            ugly = (int) curr;
            // 将 2 * ugly, 3*ugly, 5*ugly，进行去重并加入堆中
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
