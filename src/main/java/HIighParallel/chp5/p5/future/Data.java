package HIighParallel.chp5.p5.future;

/**
 * 5.5.2 Future模式中Data接口
 * 有两个重要的实现，
 *  1. RealData，也就是真实数据
 *  2. FutureData，用来提取RealData的一个“订单”
 */
public interface Data {
    public String getResult();
}
