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
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks: %s \n", getQueuedTaskCount());
            Task t1 = new Task(products, first, middle + 1, increment);
            Task t2 = new Task(products, middle+1, last, increment);
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
