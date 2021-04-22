package jcip.chp5;

import java.math.BigInteger;

/**
 *  * 程序清单5-16 使用HashMpa和同步机制来初始化缓存
 */
public class ExpensiveFunction implements Computable<String, BigInteger>{

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        // 在经过很长时间的计算后
        return new BigInteger(arg);
    }
}
