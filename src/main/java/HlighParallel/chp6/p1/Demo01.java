package HlighParallel.chp6.p1;

import java.util.Arrays;

/**
 * 声明式编程
 */
public class Demo01 {
    // 不变的对象
    static int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10};
    public static void main(String[] args) {
        int[] iArr = {1, 3, 4, 5, 6,9, 8, 7, 4, 2};
        Arrays.stream(iArr).forEach(System.out::println);
        System.out.println("=================");
        Arrays.stream(arr).map((x) -> x=x+1).forEach(System.out::println);
        System.out.println("=================");
        Arrays.stream(arr).forEach(System.out::println);

        // 使用函数式编程
        // 数组中每一个成员，首先判断是否是奇数，如果是奇数，则执行加1，
        // 并最终打印数组内所有成员。
        System.out.println("===========");
        Arrays.stream(arr).map(x -> (x%2==0?x:x+1)).forEach(System.out::println);

    }
}
