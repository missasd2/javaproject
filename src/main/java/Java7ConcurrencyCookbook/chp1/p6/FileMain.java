package Java7ConcurrencyCookbook.chp1.p6;

public class FileMain {

    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();
        System.out.println("====================");
        Thread thread1 = new Thread(new FileDate());
        thread1.start();
    }
}
