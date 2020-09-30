package Java7ConcurrencyCookbook.chp2.p6;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock接口的唯一实现类ReentrantReadWriteLock
 */
public class PricesInfo {
    private double price1;
    private double price2;
    // 声明读写锁对象
    private ReadWriteLock lock;

    public PricesInfo(){
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1(){
        lock.readLock().lock();
        double tmp = price1;
        lock.readLock().unlock();
        return tmp;
    }

    public double getPrice2(){
        lock.readLock().lock();
        double tmp = price2;
        lock.readLock().unlock();
        return tmp;
    }

    public void setPrice(double price1, double price2){
        lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        lock.writeLock().unlock();
    }
}
