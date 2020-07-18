package HIighParallel.chp3.p1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 3.1.3 信号量semaphore
 *  参数permits表示指定信号量的准入数，即同时能申请多少个许可。
 */
public class SemapDemo implements Runnable{
    // 声明包含5个许可的信号量，意味着同时可以有5个线程访问共享资源
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            // 为临界区管理代码
            // acquire，信使用acquire方法进行申请信号量操作，在离开时，使用release方法释放信号量
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semp.release();
        }

    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);

        }
    }
}
