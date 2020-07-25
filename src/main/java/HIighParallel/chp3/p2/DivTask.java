package HIighParallel.chp3.p2;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 3.2.8
 * 50.0
 * 25.0
 * 33.0
 * 100.0
 *
 */
public class DivTask implements Runnable{
    int a, b;
    public DivTask(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        for (int i = 0; i < 5; i++) {
            // i 取到了0
            //pools.submit(new DivTask(100, i));
            // 可得到部分堆栈信息 Exception in thread "pool-1-thread-1" java.lang.ArithmeticException: / by zero
            //pools.execute(new DivTask(100, i));
        }
    }
}
