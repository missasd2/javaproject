package HIighParallel.chp2.p2;

/**
 * 2.2.6 join
 * yield
 */
public class JoinMain {
    public volatile static int i = 0;
    public static class AddThread extends Thread{
        @Override
        public void run(){
            for ( i = 0; i < 10000000; i++) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        // 当前线程依赖于at线程。使用join()方法后，表示主线程愿意等待AddThread执行完毕
        // join方法的本质是让调用线程wait()在当前线程对象实例上
        at.join();
        System.out.println(i);
    }
}
