package Java7ConcurrencyCookbook.chp1.p7;

public class PlueOne implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
