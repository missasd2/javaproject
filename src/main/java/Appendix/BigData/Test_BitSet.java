package Appendix.BigData;

import java.util.BitSet;

/**
 * 测试BitSet
 */
public class Test_BitSet {
    public static void main(String[] args) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        //
        for (int i = 0; i < 16; i++) {
            if ((i%2) == 0) bits1.set(i);
            if ((i%2) != 0) bits2.set(i);
        }
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("Initial pattern in bits2: ");
        System.out.println(bits2);

        // bits2.and(bits1)
        bits2.and(bits1);
        System.out.println(" bits 2 and bits 1");
        System.out.println(bits2);
        // =============
        System.out.println("================");
        int[] array = {3, 8, 5, 7, 1};
        BitSet bitSet = new BitSet(5);
        for (int value : array) {
            bitSet.set(value, true);
        }
        bitSet.stream().forEach(e -> System.out.println(e));
    }
}
