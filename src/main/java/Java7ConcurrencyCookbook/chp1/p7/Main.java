package Java7ConcurrencyCookbook.chp1.p7;

import java.util.Date;

/**
 * thread1线程运行结束，thread2线程运行也结束的时候，主线程对象才继续运行且打印出最终的信息
 *
 * Beginning data sources loading: Fri Sep 18 16:09:03 CST 2020
 * Beginning network connections: Fri Sep 18 16:09:03 CST 2020
 * Network Connecting has been finished: Fri Sep 18 16:09:07 CST 2020
 *  Data sources loading has finished: Fri Sep 18 16:09:07 CST 2020
 * Main: Configuration has been loader: Fri Sep 18 16:09:07 CST 2020
 */
public class Main {
    public static void main(String[] args) {
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourceThread");
        Thread thread2 = new Thread(new NetworkConnectionsLoader(), "NetworkConnectionLoader");
        thread1.start();
        thread2.start();

        try {
            // 使用join方法，等待两个线程的终止
            // 若join方法传入整数参数，则只需要满足 thread1已经完成运行或过去参数表示的事件两个条件中的一个，join方法将会返回，主线程将继续执行
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Configuration has been loader: %s\n", new Date());

    }
}
