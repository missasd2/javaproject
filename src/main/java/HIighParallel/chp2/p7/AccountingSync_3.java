package HIighParallel.chp2.p7;

/**
 * synchronized关键字作用于 一个静态方法
 *  在进入increase()方法前，线程必须获得当前对象实例的锁。
 */
public class AccountingSync_3 implements Runnable{
    static AccountingSync_3 instance = new AccountingSync_3();
    static int i = 0;
    public static synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
                increase();
                System.out.println(Thread.currentThread().getName()+" i is: " + i);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * Thread的创建方式，这里使用了Runnable接口创建两个线程，
         *  这两个线程指向不同的Runnable接口实例(instance对象)
         *  但是由于方块请求的是当前类的锁，而非当前实例，因此仍线程安全
         */
        Thread t1 = new Thread(new AccountingSync_3());
        Thread t2 = new Thread(new AccountingSync_3());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i); // 20000000
    }
}
