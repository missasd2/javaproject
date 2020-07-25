package HIighParallel.chp4.p3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SimpleDateFormat不是线程安全的，在线程池中共享这个对象会导致错误。
 *
 */
public class ThreadLocaLDemo {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class ParseDate implements Runnable{
        int i = 0;
        public ParseDate(int i){this.i=i;}

        @Override
        public void run() {
            try {
                Date t = sdf.parse("2020-07-23 22:46:"+i%60);
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
