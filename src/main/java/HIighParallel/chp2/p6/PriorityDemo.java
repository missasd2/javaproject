package HIighParallel.chp2.p6;

/**
 * 使用关键字synchronized产生一次资源竞争
 * 在Java中使用1到10表示线程优先级,一般使用三个内置的静态标量来表示：
 * MIN_PRIORITY = 1
 * NORM_PRIORITY = 5
 * MAX_PRIORITY = 10
 */
public class PriorityDemo {
    public static class HighPriority extends Thread{
        static int count = 0;

        @Override
        public void run() {
            while (true){
                synchronized (PriorityDemo.class){
                    count++;
                    if ( count > 10000000){
                        System.out.println("HighPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread{
        static int count = 0;

        @Override
        public void run() {
            while (true){
               synchronized (PriorityDemo.class){
                   count++;
                   if (count > 10000000){
                       System.out.println("LowPriority is complete");
                       break;
                   }
               }
            }
        }
    }

    public static void main(String[] args) {
        HighPriority high = new HighPriority();
        LowPriority low = new LowPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }
}
