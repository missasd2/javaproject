package HlighParallel.chp6.p4;

import java.util.Arrays;
import java.util.Random;

/**
 * 并行排序
 */
public class LambdaTest04 {
    static int[] arr = {9,7, 6, 3, 2, 1, 0};

    public static  void main(String[] args) {
        // Arrays的并行排序
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("===========");

        // 给数组中每一个元素都附上一个随机值,(串行版)
        // 它的第二个参数是一个函数式接口
        Random r = new Random();
        Arrays.setAll(arr, (i) -> r.nextInt());
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("================");

        // 给数组中每一个元素都附上一个随机值,(并行版)
        // 它的第二个参数是一个函数式接口
        Arrays.parallelSetAll(arr, (i) -> r.nextInt());
        Arrays.stream(arr).forEach(System.out::println);

    }
}
