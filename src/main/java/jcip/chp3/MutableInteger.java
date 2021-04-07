package jcip.chp3;

/**
 * 程序清单3-2 非线程安全的可变整数类
 */
public class MutableInteger {

    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
