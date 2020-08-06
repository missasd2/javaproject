package HIighParallel.chp5.p4.q2;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 统筹规划的主函数，将生产者、消费者、数据都整合起来；
 */
public class PCMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        // 设置缓冲区大小为1024，为2的整数次幂
        int bufferSize = 1024;
        // 创建disruptor对象，封装了整个disruptor库的使用
        Disruptor<PCData> disruptor = new Disruptor<>(factory, bufferSize,
                executor,
                ProducerType.MULTI,
                new BlockingWaitStrategy());
        // 设置用于处理数据的消费者，设置了4个消费者实例
        // 每一个消费者实例映射到一个线程中；
        disruptor.handleEventsWithWorkerPool(
                new Consumer(),
                new Consumer(),
                new Consumer(),
                new Consumer()
        );
        // 启动并初始化disruptor系统
        disruptor.start();
        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        // 由一个生产者不断地向缓冲区存入数据；
        for (long l = 0; true; l++){
            bb.putLong(0, l);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.println(" add data " + 1);
        }
    }
}
