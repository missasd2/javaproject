package SpringInAction.chp3.CGLib;

/**
 * keyFactory 用来动态生成接口的实例，接口需要只包含一个newInstance方法，返回一个Object
 */
public interface SampleKeyFactory {
    Object newInstance(String first, int second);
}
