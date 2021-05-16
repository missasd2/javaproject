package leetcode.tag.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用两个队列 实现栈
 */
public class P225_list2Stack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public P225_list2Stack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        // 后进先出;
        // queue1 的队头作为栈顶
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }


}
