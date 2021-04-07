package SpringInAction.chp3.dynamicProxy;

public class SubjectProxy implements Subject{

    Subject subimpl = new RealSubject();
    @Override
    public void doSomething() {
        subimpl.doSomething();
    }
}
