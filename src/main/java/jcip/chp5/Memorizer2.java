package jcip.chp5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 程序清单5-12 使用ConcurrentHashMap来替换HashMap
 * @param <A>
 * @param <V>
 */
public class Memorizer2<A, V> implements Computable<A, V>{
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memorizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
