package SpringInAction.chp3.dynamicProxy;

public class RealDynamic implements Subject{

    @Override
    public void doSomething() {
        System.out.println("call doSomething()");
    }
}
