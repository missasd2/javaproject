package Java7ConcurrencyCookbook.chp1.p8;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<Event>();
        WriteTask writer = new WriteTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
