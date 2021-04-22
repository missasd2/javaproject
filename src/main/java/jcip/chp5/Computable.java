package jcip.chp5;

/**
 * 程序清单5-16 使用HashMpa和同步机制来初始化缓存
 * @param <A> 参数类型
 * @param <V> 返回值类型
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
