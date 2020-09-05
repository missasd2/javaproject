package HlighParallel.chp6.p3;

import java.io.InputStream;
import java.util.Arrays;
import java.util.function.IntConsumer;

public class LmbadaTest02 {
    static int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        /**
         * 这里首先使用函数引用，直接定义了两个IntConsumer接口实例，
         * 一个指向标准输出，另一个指向标准错误
         *
         * 用接口默认函数IntConsumer.addThen()将两个IntConsumer进行组合，
         * 得到一个新的IntConsumer，
         * 这个新的IntConsumer会依次调用outprintln和errprintln，
         * 完成对数组中元素的处理。
         */
        IntConsumer outprintln = System.out::println;
        IntConsumer errprintln = System.err::println;
        Arrays.stream(arr).forEach(outprintln.andThen(errprintln));
    }

}
