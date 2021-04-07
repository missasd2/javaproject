package DesignPattern.Behavior.ObserverPattern.dahua;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Event {
    // 被调用的对象
    private Object object;

    // 调用的方法名
    private String methodName;
    // 方法的参数
    private Object[] params;
    // 方法的参数类型
    private Class[] paramTypes;

    public Event(Object object, String methodName, Object... params) {
        this.object = object;
        this.methodName = methodName;
        this.params = params;
        initParamTypes(params);
    }
    // 初始化类型参数
    public void initParamTypes(Object[] params) {
        this.paramTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            this.paramTypes[i] = params[i].getClass();
        }
    }
    // 利用反射调用对象的方法
    public void invoke() {
        try {
            Method method = object.getClass().getMethod(this.methodName, this.paramTypes);
            if (method == null) {
                return;
            }
            method.invoke(this.object, this.params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
