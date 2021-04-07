package ArtofConcurrent.chp5.p2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {


    // 3 自定义同步器；一般情况下自定义同步器会被定义为自定义同步组件的内部类
    // 2. 定义资源数
    private final Sync sync = new Sync(2); // 设定资源数
    // 该同步器：面向线程访问和同步状态控制
    private static final class Sync extends AbstractQueuedSynchronizer {

        Sync(int count){
            if (count <= 0) throw new IllegalArgumentException("count must large than zero.");
            setState(count); // 设置同步状态；也可以理解为资源数
        }

        /**
         * 此处重写了tryAcquireShared（）方法
         * @param reduceCount
         * @return 同步器调用tryAcquireShared()方法尝试获取同步状态
         * 当返回值：
         *          大于等于0：表示能够获取到同步状态。此时，在共享式获取的自旋过程中，成功获取到同步状态并且退出；
         */
        public int tryAcquireShared(int reduceCount) {
            for (;;){
                int current = getState(); // 1 计算出获取后的同步状态
                int newCount = current - reduceCount;
                // 2 通过CAS确保状态的正确设置
                // 如果目前资源数同期望值current相等，则将状态设置为newCount;
                if (newCount < 0 || compareAndSetState(current, newCount)){
                    return newCount;
                }
            }
        }

        public boolean tryReleaseShared(int returnCount){
            for (;;){
                int current = getState();
                int newCount = current + returnCount;
                // 必须确保同步状态（或者资源数）线程安全释放，一般是通过循环和CAS来保证；
                if (compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }
    }

    @Override
    public void lock(){
        sync.acquireShared(1);
    }

    @Override
    public void unlock(){
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
