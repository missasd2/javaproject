package HIighParallel.chp2.p3;

/**
 * 2.2.6 volatile的可见性和有序性
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        // 虽然在主线程中修改了number和ready的值，
        // 但是虚拟机在Server模式下，由于系统优化的结果ReaderThread线程无法“看到”
        // 主线程中的修改，导致ReaderThread永远无法退出
        // 在client模式下，就可以看到
        Thread.sleep(10000);
    }

}
