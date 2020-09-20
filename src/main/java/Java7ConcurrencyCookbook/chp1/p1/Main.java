package Java7ConcurrencyCookbook.chp1.p1;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Calculator calculator = new Calculator(i);
            // Thread对象使用创建的Calculator对象作为构造器的参数
            // 然后调用创建的Thread对象的start方法
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
