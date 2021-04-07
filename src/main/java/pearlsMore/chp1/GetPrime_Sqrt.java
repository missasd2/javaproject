package pearlsMore.chp1;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * 程序清单P2
 */
public class GetPrime_Sqrt {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 打印不大于n的素数
    public static void prPrime(int n) {
        for (int i = 2; i <= n; i++){
            if (isPrime(i)){
                System.out.printf("%d\n", i);
            }
        }
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        prPrime(1000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
