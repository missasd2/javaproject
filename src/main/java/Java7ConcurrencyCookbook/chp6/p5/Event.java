package Java7ConcurrencyCookbook.chp6.p5;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Event implements Delayed {

    private Date startDate;
    public Event(Date startDate){
        this.startDate = startDate;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
