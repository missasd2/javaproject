package SpringInAction.chp3.dynamicProxy;

/**
 * 静态代理
 */
public class RealSubject implements Subject{

    @Override
    public void doSomething() {
        System.out.println("call doSomething()");
    }
}
