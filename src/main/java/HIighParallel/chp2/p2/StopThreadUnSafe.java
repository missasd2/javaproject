package HIighParallel.chp2.p2;

/**
 * Java线程中的Thread.yield( )方法，译为线程让步。
当一个线程使用了这个方法之后，它就会把自己CPU执行的时间让掉，
让自己或者其它的线程运行，是让自己或者其他线程运行，并不是单纯的让给其他线程。
 yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获取执行权；但是，并不能保
 *
 * 证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；也有可能是当前线程又进入到“运行状态”继续运行！
 */
public class StopThreadUnSafe {
    public static User u = new User();

    public static class ChangeObjectThread extends Thread{
        @Override
        public void run(){
            while(true){
                synchronized(u){
                    int v=(int)(System.currentTimeMillis()/1000);
                    u.setId(v);
                    //Oh, do sth. else
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run(){
            while(true){
                synchronized(u){
                    if(u.getId() != Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        new ReadObjectThread().start();
        while (true){
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop();
        }
    }
}
