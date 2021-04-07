package java7ConcurrentProgram.chp2.p6;

public class Main {
    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo();

        Reader[] readers = new Reader[5];
        Thread[] threadReader = new Thread[5];

        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(priceInfo);
            threadReader[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(priceInfo);
        Thread threadWriter = new Thread(writer);

        for (int i = 0; i < 5; i++) {
            threadReader[i].start();
        }
        threadWriter.start();
    }
}
