package Concurrent.Beauty.chp6.p1;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

public class ParkUnparkDemo {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 当一个线程调用unpark时，
         * 如果参数thread线程没有持有thread与LockSupport类关联的许可证，
         * 则让thread线程持有。
         *
         * 如果thread之前因调用park（）而被挂起，则调用unpark后，
         * 该线程会被唤醒。
         *
         * 如果thread之前没有调用park，则调用unpark方法后，
         * 再调用park方法，其会立刻返回。
         */
        System.out.println("begin park");

        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park");

        //============================
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Child thread begin park!");
                LockSupport.park();
                System.out.println("child thread unpark!");
            }
        });

        // 启动子线程
        /**
         * 首先创建了一个子线程thread，子线程启动后调用park方法，
         * 由于在默认情况下子线程没有持有许可证，因而它会把自己挂起。
         */
        thread.start();
        // 主线程休眠1s
        Thread.sleep(1000);
        System.out.println("main thread begin unpark!");
        // 主线程调用unpark让thread线程持有许可证，然后park方法返回
        /**
         * 主线程然后执行unpark方法，参数为子线程，
         * 这样做的目的是让子线程持有许可证，然后子线程调用的park方法就返回了。
         */
        LockSupport.unpark(thread);
    }


}
