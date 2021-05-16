package leetcode.tag.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class P225_list2Stack_1 {

    private Queue<Integer> queue;

    public P225_list2Stack_1() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for(int i =0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int  top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
