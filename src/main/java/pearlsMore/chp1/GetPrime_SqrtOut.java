package pearlsMore.chp1;

public class GetPrime_SqrtOut {

    public static boolean isPrime(int n) {
        int root = (int)Math.sqrt(n);
        for (int i = 2; i <= root; i++) {
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
