package HlighParallel.chp6.p1;

/**
 * 函数式接口：只定义了单一抽象方法的接口。
 * 注释FunctionalInterface用于表明IntHandler接口是一个函数式接口，
 * 该接口被定义为只包含一个抽象方法handle()，因此它符合函数式接口的定义。
 *
 *
 */
@FunctionalInterface
public interface IntHandler {
    /**
     * 函数式接口只能有一个抽象方法，而不是只能有一个方法。
     *      首先，在Java 8中，接口运行存在实例方法;
     *      其次，任何被java.lang.Object实现的方法，都不能视为抽象方法;
     * */
    void handle(int i);
    boolean equals(Object obj);
}
