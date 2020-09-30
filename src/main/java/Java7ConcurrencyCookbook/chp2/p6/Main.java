package Java7ConcurrencyCookbook.chp2.p6;

public class Main {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();

        // 创建5个读取类Reader对象
        Reader[] readers = new Reader[5];
        Thread[] threadsReader = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }

        // 创建一个写入类Writer对象,并将其作为传入参数创建线程
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);

        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}
