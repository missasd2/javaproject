package Java7ConcurrencyCookbook.chp1.p1;

public class Calculator implements Runnable{
    private int number;

    // 构造函数
    public Calculator(int number){
        this.number = number;
    }

    // 每个线程会执行各自的run方法，
    @Override
    public void run(){
        for (int i = 0; i <= 10 ; i++) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i*number);
        }
    }
}
