package SpringInAction.chp3.dynamicProxy;

public class TestDynamicProxy {

    public static void main(String[] args) {
        ProxyHandler proxy = new ProxyHandler();
        // 绑定该类实现的所有接口
        // new RealDynamic() 生成的是代理对象
        Subject sub = (Subject) proxy.bind(new RealDynamic());
        sub.doSomething(); // 代理类执行接口方法时，会自动调用invoke()方法，
    }
}
