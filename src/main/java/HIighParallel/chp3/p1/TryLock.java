package HIighParallel.chp3.p1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 限时等待也可不带参数：
 *  如果锁被其它线程占用，则当前线程不会进行等待，立即返回false。
 *  这个模式不会引起线程等待，也不会产生死锁
 */
//public class TryLock implements Runnable{
//
//    public static ReentrantLock lock1 = new ReentrantLock();
//    public static ReentrantLock lock2 = new ReentrantLock();
//    int lock;
//
//    public TryLock(int lock){
//        this.lock = lock;
//    }
//
//    @Override
//    public void run() {
//        if (lock == 1){
//            while (true){
//                if (lock1.tryLock()){
//                    try {
//                        try {
//                            Thread.sleep(500);
//                        }catch (InterruptedException e){
//                    }
//                    if (lock2.tryLock()){
//                        try {
//                            System.out.println(Thread.currentThread().getId() + " : My Job done");
//                            return;
//                        }finally {
//                            lock2.unlock();
//                        }
//                        }
//                    }finally {
//                        lock1.unlock();
//                    }
//                }else {
//                    while (true){
//                        if (lock2.tryLock())
//                    }
//                }
//            }
//        }
//    }
//}
