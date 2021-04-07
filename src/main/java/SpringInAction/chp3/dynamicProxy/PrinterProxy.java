package SpringInAction.chp3.dynamicProxy;

/**
 * 静态代理
 * PrinterProxy 为代理类
 */
public class PrinterProxy implements IPrinter{
    private IPrinter printer;
    public PrinterProxy() {
        this.printer = new Printer(); // 构造函数中将目标对象传入进去
    }

    @Override
    public void print() {
        System.out.println("记录日志");
        printer.print(); // 实现接口的方法时，调用目标类的方法，并加入新的功能
    }
}
