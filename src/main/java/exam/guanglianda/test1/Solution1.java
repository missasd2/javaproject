package exam.guanglianda.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 构造大小为n的堆
        for (int i = 0; i < n; i++){
            queue.offer(sc.nextInt());
        }

        for (int i = 0; i < m; i++){
            int temp = queue.poll();
            temp = temp + x;
            queue.offer(temp);
        }
        System.out.println(queue.poll());
    }
}
