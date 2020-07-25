package HIighParallel.chp3.p2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 3.2.6
 */
public class ExtThreadPool {

    public static class MyTask implements Runnable{
        public String name;

        public MyTask() { }

        public MyTask(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行 " + ":Thread ID: " + Thread.currentThread().getId() + " , Task Name= " + name);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadPoolExecutor(5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>())
        {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行: " + ((MyTask) r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成: " + ((MyTask) r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");

            }
        };
    }
}
