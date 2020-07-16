package HIighParallel.chp2.p2;
/**
 * 方法二，向Thread的构造方法传入一个Runnable接口的实例
 */
public class MyThread_Runnable implements Runnable {
    @Override
    public void run(){
        System.out.println("I am thred t1");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread_Runnable());
        thread.start();

    }
}
