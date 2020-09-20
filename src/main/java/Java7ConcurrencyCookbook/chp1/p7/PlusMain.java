package Java7ConcurrencyCookbook.chp1.p7;

public class PlusMain {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PlueOne());
        Thread thread2 = new Thread(new PlueOne());
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All thread has finished");
    }
}
