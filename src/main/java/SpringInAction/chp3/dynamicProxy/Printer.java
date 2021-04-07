package SpringInAction.chp3.dynamicProxy;

public class Printer implements IPrinter{

    @Override
    public void print() {
        System.out.println("打印!");
    }
}
