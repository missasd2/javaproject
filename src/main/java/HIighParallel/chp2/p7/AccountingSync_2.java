package HIighParallel.chp2.p7;

/**
 * synchronized关键字作用于 一个实例方法
 *  在进入increase()方法前，线程必须获得当前对象实例的锁。
 */
public class AccountingSync_2 implements Runnable{
    static AccountingSync_2 instance = new AccountingSync_2();
    static int i = 0;
    public synchronized void increase(){
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
         *  这两个线程都指向同一个Runnable接口实例(instance对象)
         *  才能保证两个线程在工作时，能够关注到同一个对象锁上，从而保证线程安全
         */
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i); // 20000000
    }
}
