package Appendix.BigData;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;

/**
 * 测试BitSet
 */
public class Test_BitSet1 {
    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            int randomResult = random.nextInt(10000000);
            list.add(randomResult);
        }
        System.out.println("产生的随机数有");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        BitSet bitSet = new BitSet(10000000);
        for (int i = 0; i < 10000000; i++) {
            bitSet.set(list.get(i));
        }

        System.out.println("0~1亿不在上述随机数中有"+bitSet.cardinality());
        for (int i = 0; i < 10000000; i++) {
            if (!bitSet.get(i)){
                System.out.println(i);
            }
        }
    }
}
