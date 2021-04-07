package jcip.chp3;

import jcip.annotate.GuardeBy;
import jcip.annotate.ThreadSafe;
import org.junit.runner.notification.RunListener;

/**
 * 程序清单3-3 线程安全的可变整数类
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardeBy("this") private int value;

    public synchronized int get() {return  value;}

    public synchronized void set(int value) {this.value = value;}
}
