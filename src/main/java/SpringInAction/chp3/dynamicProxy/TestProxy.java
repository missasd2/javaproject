package SpringInAction.chp3.dynamicProxy;

public class TestProxy {

    public static void main(String[] args) {
        Subject sub = new SubjectProxy();
        sub.doSomething();
    }
}
