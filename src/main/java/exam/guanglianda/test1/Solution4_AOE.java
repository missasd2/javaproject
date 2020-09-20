package exam.guanglianda.test1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4_AOE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();

        long[][] boss = new long[n][2];

        for (int i = 0; i < n; i++){
            boss[i][0] = sc.nextLong();
            boss[i][1] = sc.nextLong();
        }
        // 升序排序
        Arrays.sort(boss, (p, q) -> (int)(p[0] - q[0]));
        long cnt = 0;
        int bos = 0;
        while (bos < n){
            cnt += boss[bos][1];
            long dead = boss[bos][1];
            for (int i = bos; i < n; i++) {
                if (boss[i][0] <= boss[bos][0] + 2 * y){
                    boss[i][1] -= dead;
                }else {
                    break;
                }
            }
            while (bos < n && boss[bos][1] <= 0){
                bos++;
            }
        }
        System.out.println(cnt);
    }
}
