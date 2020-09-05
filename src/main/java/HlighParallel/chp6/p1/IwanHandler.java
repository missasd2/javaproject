package HlighParallel.chp6.p1;

/**
 * 只要符合函数式接口的定义，即使没有@FunctionalInterface注解也会被认定为函数式接口
 */
public interface IwanHandler {
    void handle(int i);
}
