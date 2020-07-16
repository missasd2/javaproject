package HIighParallel.chp2.p2;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        // 调用Thread对象的start方法
//        Thread t1 = new Thread(){
//            @Override
//            public void run(){
//                System.out.println("Hello I am t1");
//            }
//        };
//        t1.start();
//        Thread.sleep(2000);
//        // 由于没有中断处理的逻辑，因此t1线程被置为中断状态，这个中断不会发生任何作用
//        t1.interrupt();

//        // 添加中断处理逻辑
//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                while (true){
//                    // 中断处理的逻辑
//                    if (Thread.currentThread().isInterrupted()){
//                        System.out.println("Interruted!");
//                        break;
//                    }
//                    Thread.yield();
//                }
//            }
//        };
//        t1.start();
//        Thread.sleep(2000);
//        t1.interrupt();

        // Thread.sleep()在执行过程中，被中断，程序会抛出异常。
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Interruted! ");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println("Interruted When Sleep");
                        // 设置中断状态，再次中断自己
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();

    }
}
