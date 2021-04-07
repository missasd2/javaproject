package pearlsMore.chp1;

/**
 * 程序清单P5 用乘法
 */
public class GetPrime_Multiply {
    public static boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        if (n % 5 == 0) return n == 5;
        for (int i = 7; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void prPrime(int n) {
        for (int i = 2; i <= n; i++){
            if (isPrime(i)){
                System.out.printf("%d\n", i);
            }
        }
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        prPrime(100000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
