package HIighParallel.chp5.p5.future;

/**
 * FutureData实现了一个快速返回的RealData包装。
 * 它只是一个包装，或者说是一个RealData的虚拟实现。
 * 因此，它可以很快被构造并返回。
 * 当使用FutrueData的getResult()方法时，
 * 如果实际的数据没有准备好，那么程序就会阻塞，
 * 等RealData准备好并注入FutureData中才最终返回数据。
 */
public class FutureData implements Data {

    protected RealData realData = null; // FutureData是RealData的包装
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();   // RealData已经被注入，通知getResult()方法
    }

    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                wait();  // 一直等待，直到RealData被注入
            } catch (InterruptedException e) {
            }
        }
        return realData.result; // 由realData实现
    }
}
