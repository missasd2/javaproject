package Java7ConcurrencyCookbook.chp1.p3;

public class Calculator implements Runnable{
    private int number;

    public Calculator(int number){
        this.number = number;
    }

    public Calculator(){};


    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            System.out.printf("%s: %d * %d = %d \n", Thread.currentThread().getName(), i, number, i*number);
        }
    }
}
