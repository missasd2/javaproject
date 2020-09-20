package Java7ConcurrencyCookbook.chp1.p6;

import HIighParallel.chp5.p5.future.Data;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 1.6 线程的休眠和恢复
 * 每个1秒打印当前时间
 * 当调用sleep()方法之后，线程会释放CPU并且不再继续执行任务。
 * 在这段时间内，线程不占用CPU时钟，所以CPU可以执行其它的任务；
 *
 * 如果休眠中线程被中断，该方法会立即抛出InterruptedException异常，
 * 而不需要等待休眠时间结束；
 *
 */
public class FileClock implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Thread 1 :%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);

            }catch (InterruptedException e){
                System.out.println("The FileColock has been interrupted");
            }
        }
    }
}
