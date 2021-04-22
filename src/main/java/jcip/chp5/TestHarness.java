package jcip.chp5;

import java.util.concurrent.CountDownLatch;

/**
 * 代码清单5-11 在计时测试中使用 CountDownLatch 来启动和停止线程
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1); // 起始门的初始计数器为1
        final CountDownLatch endGate = new CountDownLatch(nThreads); // 结束门计数器的初始值为工作线程的数量

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        // 1. 在启动门上等待，从而确保所有线程都就绪后才开始执行
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            // 3. 每个线程要做的最后一件事是将调用结束门的countDown()方法将结束门的计数器值减1，
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }


}
