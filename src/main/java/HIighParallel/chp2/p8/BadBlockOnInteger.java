package HIighParallel.chp2.p8;

/**
 * 把锁加在变量上：
 *      对Integer类型来说，在Java中Integer属于不变对象。
 *      代码实际上使用了Integer.valueOf()方法每次新建了一个新的Integer对象，并将它赋值给变量i；
 *      在多个线程间，并不一定能够看到同一个i对象，
 *      因此两个线程每次加锁可能都加在了不同的对象实例上，从而导致临界区代码控制出现问题。
 *      解决方法将synchronized (i)改为synchronized (instance)
 */
public class BadBlockOnInteger implements Runnable {
    public static Integer i = 0;
    static BadBlockOnInteger instance = new BadBlockOnInteger();
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            synchronized (i){
                i++;
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
        System.out.println(i);
    }
}
