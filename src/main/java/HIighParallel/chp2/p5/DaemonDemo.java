package HIighParallel.chp2.p5;

/**
 * 2.5 Daemon守护线程
 */
public class DaemonDemo {

    public static class DaemonT extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("I am alive");;
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonT t = new DaemonT();
        // 将线程t设置为守护线程，且设置必须要在start()之前否则报错
        t.setDaemon(true);
        t.start();
        // 由于线程t被设置为守护线程，因此用户线程就只有main线程。
        // 在main线程休眠2秒后，整个程序也随之结束
        Thread.sleep(2000);
    }
}
