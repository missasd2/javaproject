package HIighParallel.chp2.p2;

/**
 * 1594632745725:T1 start!
 * 1594632745725 T1 wait for object
 * 1594632745725:T2 start! notify one thread
 * 1594632745725:T2 end!
 * 1594632747726:T1 end! 需要等待T2释放object的对象锁，T1重新成功获得锁后，才能继续执行
 */
public class SimpleWN {
    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            // 将object对象加上对象锁,线程只能互斥的访问这个对象
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + " T1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }


    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();


    }
}
