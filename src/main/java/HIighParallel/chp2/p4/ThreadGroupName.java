package HIighParallel.chp2.p4;

public class ThreadGroupName implements Runnable {
    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()
                + "-" + Thread.currentThread().getName();
        while (true){
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 建立名为PrintGroup的线程组
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        // 创建两个线程，并将其与线程组关联起来
        Thread t1 = new Thread(tg, new ThreadGroupName(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupName(), "T2");
        t1.start();
        t2.start();
        // 线程组可以获得活动线程的总数
        System.out.println(tg.activeCount());
        // 打印线程组的所有线程信息
        tg.list();
    }
}
