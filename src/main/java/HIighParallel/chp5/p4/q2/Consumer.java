package HIighParallel.chp5.p4.q2;

import com.lmax.disruptor.WorkHandler;

/**
 * 消费者的作用是读取数据进行处理；
 * 数据的读取由Disruptor框架进行封装了，onEvent()方法为框架的回调方法；
 */
public class Consumer implements WorkHandler<PCData> {

    @Override
    public void onEvent(PCData event) throws Exception {
        System.out.println(Thread.currentThread().getId() +
                ":Event: --" + event.get() * event.get() + "--");
    }
}
