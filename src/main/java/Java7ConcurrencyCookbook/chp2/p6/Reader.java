package Java7ConcurrencyCookbook.chp2.p6;

/**
 * 读取价格信息PricesInfo
 */
public class Reader implements Runnable{
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo){
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s : Price 1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
            System.out.printf("%s : Price 2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }
}
