package Java7ConcurrencyCookbook.chp3.p4;

import HIighParallel.chp3.p1.CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable{
    private final CountDownLatch contorller;

    public Videoconference(int number){
        contorller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived.", name);
        // countDown方法将CountDownLatch类的内部计数器减1；
        contorller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants. \n", contorller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants. \n", contorller.getCount());
        try {
            contorller.await();
            System.out.printf("VideoConference: All the participants have come \n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
