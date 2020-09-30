package Appendix.BigData;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计算自定义错误率
 */
public class Test_BloomFilter_ErrorPer {
    private static int size = 1000000;

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size);

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        List<Integer> list = new ArrayList<Integer>(1024);
        // 故意取不在范围中的值，计算误判率
        for (int i = size + 10000 ; i < size + 20000; i++) {
            if (bloomFilter.mightContain(i)){
                list.add(i);
            }
        }
        System.out.println("误判的数量： "+list.size());
        List<Integer> lists = new ArrayList<>();

    }
}
