package Concurrent.Beauty.chp4.p3;

import HIighParallel.chp5.p3.Producer;

import java.util.concurrent.TimeUnit;

/**
 * 4.3.6 ThreadLocal的使用
 * ThreadLocal，即线程变量，是一个以ThreadLocal对象为键，任意对象为值的存储结构；
 * 这个结构被附带在线程上，
 * 一个线程可以根据一个ThreadLocal对象查询到绑定在这个线程上的一个值；
 *可以通过set(T)方法来设置一个值，在当前线程下再通过get()方法获取到原先设置的值。
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
      protected Long initialValue(){
          return System.currentTimeMillis();
      }
    };

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills ");
    }
}
