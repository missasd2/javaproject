package Concurrent.Beauty.chp6.p1;

import java.util.concurrent.locks.LockSupport;

public class ParkUnparkDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park! ");
                // 调用park方法，挂起自己，只有被中断才会退出循环
                /**
                 * park方法返回时不会告诉你因何种原因返回，
                 * 所以调用者需要根据之前调用park方法的原因，再次检查条件是否满足，
                 * 如果不满足则还需要再次调用park方法。
                 */
                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }
                System.out.println("child thread unpark! ");
            }
        });

        // 启动子程序
        thread.start();
        // 主线程休眠1s
        Thread.sleep(1000);
        System.out.println("main thread begin unpark");
        // 中断子程序
        // 调用park方法后的线程被中断后会返回parkNanos(long nanos)方法
        thread.interrupt();
    }


}
