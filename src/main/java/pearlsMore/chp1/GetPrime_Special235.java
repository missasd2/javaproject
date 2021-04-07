package pearlsMore.chp1;

/**
 * 程序P4
 */
public class GetPrime_Special235 {

    public static boolean isPrime(int n) {

        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        if (n % 5 == 0) return n == 5;

        int root = (int)Math.sqrt(n);
        for (int i = 7; i < root; i++) {
            if (n % i == 0) {
                return false;
            }
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
