package Java7ConcurrencyCookbook.chp6.p4;

import java.util.PriorityQueue;

public class Event implements Comparable<Event>{
    // 存放创建了event的线程数
    private int thread;

    private int priority;

    public Event(int thread, int priority){
        this.thread = thread;
        this.priority = priority;
    }

    public int getThread(){
        return thread;
    }

    public int getPriority(){
        return priority;
    }

    /**
     * compareTo(Event e):
     * 比较当前对象与传入的对象Event e的指定顺序；
     * 如果该对象小于、等于或大于指定对象，则分别返回负整数、零、正整数
     * 这里的实现与大多数Comparator.compareTo()实现相反，
     * 因此这里的优先级是从高到低的
     * @param e
     * @return
     */
    @Override
    public int compareTo(Event e){
        if (this.priority > e.getPriority()){
            return -1;
        }else if (this.priority < e.getPriority()){
            return 1;
        }else {
            return 0;
        }
    }


}
