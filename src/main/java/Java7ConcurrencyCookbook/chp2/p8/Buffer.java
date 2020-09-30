package Java7ConcurrencyCookbook.chp2.p8;

import HIighParallel.chp3.p1.ReenterLock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 数据缓冲类，将被生产者和消费者共享
 */
public class Buffer {
    private LinkedList<String> buffer; // 存放共享数据
    private int maxSize; // 存放buffer的长度
    private ReentrantLock lock; // 对修改buffer的代码进行控制
    private Condition lines;
    private Condition space;
    private boolean pendingLines; // 表明缓冲区中是否还有数据

    public Buffer(int maxSize){
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    // 将传入的字符串写入到缓冲区中
    public void insert(String line){
        lock.lock(); // 获取锁
        try {
            while (buffer.size() == maxSize){
                space.await();
            }
            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    // 返回缓冲区的第一个字符串
    public String get(){
        String line = null;
        lock.lock();
        try {
            while ((buffer.size() == 0) && (hasPendingLines())){
                lines.await();
            }
            if (hasPendingLines()){
                line = buffer.poll();
                System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
                space.signalAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return line;
    }

    public void setPendingLines(boolean pendingLines){
        this.pendingLines = pendingLines;
    }

    /**
     *
     * @return 如果有数据行时返回true
     */
    public boolean hasPendingLines(){
        return pendingLines || buffer.size() > 0;
    }
}
