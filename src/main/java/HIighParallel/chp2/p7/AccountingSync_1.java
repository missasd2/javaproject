package HIighParallel.chp2.p7;

/**
 * synchronized关键字作用于给定对象
 *  每次当线程进入被关键字synchronized包裹的代码段，都会要求请求instance实例的锁。
 *  如果当前有其它线程正持有这把锁，那么新到的线程就必须等待。
 *  保证了每次只有一个线程执行i++操作。
 */
public class AccountingSync_1 implements Runnable{
    static AccountingSync_1 instance = new AccountingSync_1();
    static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            synchronized (instance){
                i++;
                System.out.println(Thread.currentThread().getName()+" i is: " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i); // 20000000
    }
}
