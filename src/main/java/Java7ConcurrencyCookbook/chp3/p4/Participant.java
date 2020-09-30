package Java7ConcurrencyCookbook.chp3.p4;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable{
    private Videoconference conference;
    private String name;

    public Participant(Videoconference conference, String name){
        this.conference = conference;
        this.name = name;
    }



    @Override
    public void run() {
        long duration = (long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 表明一个与会者的到来
        conference.arrive(name);
    }
}
