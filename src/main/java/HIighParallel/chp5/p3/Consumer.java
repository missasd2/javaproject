package HIighParallel.chp5.p3;

import javax.swing.*;
import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<PCData> queue;   // 缓冲区
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("start Consumer id= " + Thread.currentThread().getId());
        Random r = new Random(); // 随机等待时间
        try {
            while (true){
                PCData data = queue.take();// 提取任务
                if (data != null){
                    int re = data.getData() * data.getData(); // 计算平方
                    System.out.println(MessageFormat.format("{0}*{1}={2}",
                            data.getData(), data.getData(), re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 建立缓冲区
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<>(10);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        ExecutorService service = Executors.newCachedThreadPool(); // 建立线程池
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        Thread.sleep(10 * 1000);
        producer1.stop();                // 停止生产者
        producer2.stop();
        producer3.stop();
        Thread.sleep(30000);
        service.shutdown();
    }
}
