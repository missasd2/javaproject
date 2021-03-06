package HIighParallel.chp5.p5.future;

/**
 * RealData是最终需要使用的数据模型。它的构造很慢。用sleep()函数模拟这个过程，简单地模拟一个字符串的构造。
 */
public class RealData implements Data {
    protected String result;

    @Override
    public String getResult() {
        return result;
    }

    public RealData(String para) {
        // RealData的构造可能很慢，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                // 使用sleep，代替一个很慢的操作过程
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            result = sb.toString();
        }
    }

}
