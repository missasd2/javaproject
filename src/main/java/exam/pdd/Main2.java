package exam.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
            if (tmp == 1) {
                list.add(i);
            }
        }

        int n = list.size();
        if (n == 0 || n == 1) {
            System.out.println(N);
        }
        if (n == N) {
            System.out.println(N - 1);
        }



    }
}
