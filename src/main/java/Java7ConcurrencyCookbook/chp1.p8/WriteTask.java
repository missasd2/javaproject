package Java7ConcurrencyCookbook.chp1.p8;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriteTask implements Runnable{

    private Deque<Event> deque;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("Thread %s has generated an event", Thread.currentThread().getId()));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public WriteTask(Deque<Event> deque){
        this.deque = deque;
    }
}
