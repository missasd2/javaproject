package SpringInAction.chp3.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

    private Object tar;

    // 绑定委托对象，并返回代理类
    public Object bind(Object tar) {
        this.tar = tar; // this.tar 代表被代理的对象
        // 绑定该类实现的所有接口,取得代理类

        // 使用Proxy.newProxyInstance()静态方法可以生成代理对象
        // ClassLoader loader: 被代理对象的类加载器
        // Class<?> interfaces: 被代理类全部的接口
        // InvocationHandler h: 实现InvocationHandler接口的对象
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                                    tar.getClass().getInterfaces(),
                this
                );
    }

    /**
     * invoke()方法在，代理对象调用方法时调用
     * @param proxy 被代理的对象
     * @param method 要调用的方法
     * @param args 方法调用时所需要的参数
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Object result = null;
        // 这里就可以进行所谓的AOP编程了
        // 在调用具体函数方法前，执行功能处理
        result = method.invoke(tar, args);
        // 在调用具体函数方法后，执行功能处理
        return result;
    }
}
