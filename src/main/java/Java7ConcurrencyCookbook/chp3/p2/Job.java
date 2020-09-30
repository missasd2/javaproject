package Java7ConcurrencyCookbook.chp3.p2;

public class Job implements Runnable{
    // 声明一个打印队列对象
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue){
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        // 调用打印队列对象的printJob()方法
        printQueue.printJob(new Object());
        // 将工作完成的信息打印到控制台
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }

}
