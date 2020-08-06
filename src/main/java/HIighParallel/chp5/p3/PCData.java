package HIighParallel.chp5.p3;

/**
 * PCData对象作为生产者和消费者之间的共享数据模型；
 */
public final class PCData {
    private final int intData; // 数据
    public PCData(int d){
        intData = d;
    }
    public PCData(String d){
        intData = Integer.valueOf(d);
    }
    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
