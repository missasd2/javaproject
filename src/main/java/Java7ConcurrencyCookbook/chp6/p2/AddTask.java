package Java7ConcurrencyCookbook.chp6.p2;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable{

    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list){
        this.list = list;
    }

    /**
     * 将10000个字符串存放到列表中，字符串由当前执行任务的线程的名称和数字组成
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Element " + i);
        }
    }
}
