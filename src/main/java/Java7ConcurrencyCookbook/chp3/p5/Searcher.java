package Java7ConcurrencyCookbook.chp3.p5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 查找类，在随机数矩阵指定的行中查找某个数
 * CyclicBarrier类有内部计数器，可以控制指定数目的几个线程必须都到达集合点
 * 每一个线程到达集合点后就会调用await()方法通知CyclicBarrier对象，CyclicBarrier对象会让这个线程休眠直到其他所有的线程都到达集合点
 * 当所有的线程都到达集合点后，CyclicBarrier对象就唤醒所有在await()方法里等待的线程；
 * 同时可以以向构造器传入的Runnable对象，创建一个新的线程，以执行其他任务；
 */
public class Searcher implements Runnable{
    // 决定查找的子集范围
    private int firstRow;
    private int lastRow;

    private MatrixMock mock;
    private Results results;
    // 用于存放要查找的数字
    private int number;
    //
    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    // 使用内部变量counter来存放每行查找到的次数
    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d. \n", Thread.currentThread().getName(), firstRow, lastRow);
        for (int i = firstRow; i < lastRow; i++) {
            int[] row = mock.getRow(i);
            counter = 0;
            for (int j = 0; j <  row.length; j++) {
                if (row[j] == number) counter++;
            }
            results.setData(i, counter);
        }
        System.out.printf("%s: Lines processed. \n", Thread.currentThread().getName());

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
