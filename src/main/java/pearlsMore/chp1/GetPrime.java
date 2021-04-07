package pearlsMore.chp1;

/**
 * 程序P1 打印所有小于1000的素数
 */
public class GetPrime {


    // 判断某个数是否为素数
    public static boolean isPrime(int n) {

        for (int i = 2; i < n; i++) {
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
