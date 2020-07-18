package HIighParallel.chp3.p1;


import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterDemo {
    // 限定RateLimiter每秒只能处理两个请求。
    static RateLimiter limiter = RateLimiter.create(2);

    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            // 调用acquire()方法来控制流量
            limiter.acquire();
            new Thread(new Task()).start();
        }
    }
}
