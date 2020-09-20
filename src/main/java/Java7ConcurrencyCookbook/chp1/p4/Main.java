package Java7ConcurrencyCookbook.chp1.p4;

public class Main {

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
