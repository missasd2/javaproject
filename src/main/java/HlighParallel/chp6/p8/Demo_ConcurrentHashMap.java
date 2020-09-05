package HlighParallel.chp6.p8;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 6.8.2 reduce操作
 * ConcurrentHashMap使用示例
 * 并行计算ConcurrentHashMap中所有Value的总和
 */
public class Demo_ConcurrentHashMap {


    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 100 ; i++) {
            map.put(Integer.toString(i), i);
        }
        // 第一个参数表示并行度，表示一个并行任务可以处理的元素个数
        // reduce()参数相当于：(((1 + 2) + 3) + 4)
        int count = map.reduceValues(2, (i, j) -> i + j);
        System.out.println(count);
    }


}
