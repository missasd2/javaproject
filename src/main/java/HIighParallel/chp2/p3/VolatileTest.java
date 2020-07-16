package HIighParallel.chp2.p3;

/**
 * volatile 不能代替锁,无法保证一些符合操作的原子性
 */
public class VolatileTest {
    static volatile int i = 0;
    public static class PlusTask implements Runnable{
        @Override
        public void run(){
            for (int k = 0; k < 1000; k++) {
                i++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
             threads[i] = new Thread(new PlusTask());
             threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(i);
    }
}
