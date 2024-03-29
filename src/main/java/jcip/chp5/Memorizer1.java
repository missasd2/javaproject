package jcip.chp5;

import jcip.annotate.GuardeBy;

import java.util.HashMap;
import java.util.Map;

public class Memorizer1<A, V> implements Computable<A, V>{

    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memorizer1(Computable<A, V> c) {
        this.c = c;
    }



    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }


}
