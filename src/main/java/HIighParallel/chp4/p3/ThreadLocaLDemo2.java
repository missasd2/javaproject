package HIighParallel.chp4.p3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SimpleDateFormat不是线程安全的，在线程池中共享这个对象会导致错误。
 * ThreadLocal只起到了简单的容器作用；
 * 为每一个线程分配一个对象的工作不是由ThreadLocal来完成的，而是需要在应用层面来保证的。
 * 如果在应用上为每一个线程分配了相同的对象实例，那么ThreadLocal也不能保证线程安全。
 *
 */
public class ThreadLocaLDemo2 {
    static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
    public static class ParseDate implements Runnable{
        int i = 0;
        public ParseDate(int i) {this.i=i;}

        @Override
        public void run() {
            try {
                // 如果当前线程不持有SimpleDateformat对象实例，
                // 就新建一个并把它设置到当前线程中
                if (tl.get() == null) {
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));;
                }
                // 若已经持有则直接使用
                Date t =tl.get().parse("2020-07-23 22:46:"+i%60);
                System.out.println(i+":"+t);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }

    }
}
