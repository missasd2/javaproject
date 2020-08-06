package HIighParallel.chp5.p4.q2;

import com.lmax.disruptor.EventFactory;

/**
 * 一个产生PCData对象的工厂。会在Disruptor框架系统初始化时，
 * 构造所有的缓冲区中的对象实例
 */
public class PCDataFactory implements EventFactory<PCData> {

    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
