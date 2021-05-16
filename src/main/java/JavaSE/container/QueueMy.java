package JavaSE.container;

public interface QueueMy<T> {

    /**
     * 初始化队列  构造一个空队列
     */
    T InitQueue();
    /**
     * 销毁队列
     */
    QueueMy DestroyQueue();

    /**
     * 清空队列
     */
    QueueMy ClearQueue();

    /**
     * 队列判空
     */
    boolean isEmpty();

    /**
     * 返回队列长度
     */
    int size();

    /**
     * 返回队列头元素
     */

}
