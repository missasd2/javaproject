package HIighParallel.chp5.p4.q2;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class Producer {
    private final RingBuffer<PCData> ringBuffer;
    public Producer(RingBuffer<PCData> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    /**
     * pushData()方法
     *  将产生的数据推入缓冲区，方法接收一个ByteByffer对象
     *  ByteBuffer 对象中可以用来包装任何数据类型。这里用来存储long整数
     *  pushData()方法的作用是将传入ByteBuffer对象中的数据提取出来，并装载到环形缓冲区中；
     *
     * @param bb
     */

    public void pushData(ByteBuffer bb){
        long sequence = ringBuffer.next(); //  获得下一个可用的序列号
        try{
            // 通过序列号，取得下一个空闲可用的PCData对象，
            // 并将PCData对象的数据设为期望值
            PCData event = ringBuffer.get(sequence);
            event.set(bb.getLong(0)); //Fill with data
        }
        finally {
            // 进行数据发布，只有发布后的数据才会真正被消费者看见；
            ringBuffer.publish(sequence);
        }
    }
}
