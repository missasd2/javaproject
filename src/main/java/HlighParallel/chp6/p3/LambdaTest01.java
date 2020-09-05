package HlighParallel.chp6.p3;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class LambdaTest01 {
    static int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10};
    public static void main(String[] args) {
        // 传统打印数组方式
        for (int i : arr){
            System.out.print(i + " ");
        }

        // lambda使用引用函数的形式
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("================");

        // lambda使用流的形式；引入了不必要的接口和匿名类
        /**
         * Arrays.stream()返回了一个流对象。
         */
        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value + " ");
            }
        });
        System.out.println();
        System.out.println("================");

        // 省略了接口名称IntStream; 只使用了参数名和一个实现体
        Arrays.stream(arr).forEach( (final int x) -> {
                    System.out.println(x);
                });
        System.out.println("============");
        // 省略参数的类型；只使用参数名和一个实现体
        Arrays.stream(arr).forEach((x) -> {
            System.out.print(x + " ");
        });
        System.out.println();
        System.out.println("===============");

        // 省略花括号
        Arrays.stream(arr).forEach((x) -> System.out.println(x));
        System.out.println("=================");
        // 省略参数声明和传递
        Arrays.stream(arr).forEach(System.out::println);

    }
}
