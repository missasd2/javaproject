package Java7ConcurrencyCookbook.chp5.p2;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * RecursiveAction: 用于任务没有返回结果的场景
 * RecursiveTask: 用于任务有返回结果的场景
 *
 */
public class Task extends RecursiveAction {

    private static final long serialVersionUID = 1L;

    private List<Product> products;
    // 决定任务执行时对产品的分块
    private int first;
    private int last;

    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    // 重写compute()方法，实现任务的执行逻辑
    @Override
    protected void compute() {
        if (last - first < 10){
            updatePrices();
        }else {
            // 如果一个任务需要更新大于10个元素，将这个列表分为两个部分
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks: %s \n", getQueuedTaskCount());
            // 分别创建两个任务用来更新各自部分的产品价格
            Task t1 = new Task(products, first, middle + 1, increment);
            Task t2 = new Task(products, middle+1, last, increment);
            // invokeAll()方法来执行一个主任务所创建的多个子任务。
            // 这是一个同步调用，即调用者会主动等待调用的结果
            // 这也是一个非阻塞的线程；
            // 当一个主任务等待它的子任务时，执行这个主任务的工作者线程接收另一个等待执行的任务并开始执行
            invokeAll(t1, t2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice()* (1 + increment));
        }
    }
}
