package Java7ConcurrencyCookbook.chp6.p4;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable{

    private int id;

    private PriorityBlockingQueue<Event> queue;

    public Task(int id, PriorityBlockingQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    /**
     * 向队列中添加1000个Event对象
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Event event = new Event(id, i);
            queue.add(event);
        }
    }
}
