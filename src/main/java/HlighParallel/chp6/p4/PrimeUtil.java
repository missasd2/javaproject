package HlighParallel.chp6.p4;

import javax.print.attribute.IntegerSyntax;
import java.util.stream.IntStream;

/**
 * 统计1～1 000 000内质数的数量
 */
public class PrimeUtil {
    // 判断质数的函数
    public static boolean isPrime(int number){
        int tmp = number;
        if (tmp < 2) return false;
        for (int i = 2; i <= Math.sqrt(tmp); i++) {
            if (tmp % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 使用函数式编程统计给定范围内所有的质数
        // 上述代码首先生成一个1到1 000 000的数字流。
        // 接着使用过滤函数，只选择所有的质数，最后进行数量统计。
        IntStream.range(1, 1000000).filter(PrimeUtil::isPrime).count();

        // 改造成并行化
        //parallel()方法得到一个并行流，然后在并行流上进行过滤，
        // 此时，PrimeUtil.isPrime()函数会被多线程并发调用，应用于流中的所有元素。
        IntStream.range(1, 1000000).parallel().filter(PrimeUtil::isPrime).count();
    }
}
