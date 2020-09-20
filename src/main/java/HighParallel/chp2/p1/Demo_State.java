package HighParallel.chp2.p1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo_State {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(2);
        pq.add(1);
        pq.add(10);
        pq.add(3);

        // 默认是最小堆
        while (!pq.isEmpty()){
            System.out.println(pq.poll() + " , ");
        }
        System.out.println();
        System.out.println("=============");
        // 使用自定义比较器
        /**
         * public static int compare(int x, int y) {
         *         return (x < y) ? -1 : ((x == y) ? 0 : 1);
         *     }
         */
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        pq2.add(5);
        pq2.add(2);
        pq2.add(1);
        pq2.add(10);
        pq2.add(3);
        while (!pq2.isEmpty()){
            System.out.println(pq2.poll() + ",");
        }

        try {
            System.out.println(1/0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
