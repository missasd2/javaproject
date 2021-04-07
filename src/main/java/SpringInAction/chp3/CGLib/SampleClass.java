package SpringInAction.chp3.CGLib;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.ImmutableBean;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * CGLib：主要通过对字节码的操作，为对象引入间接级别，以控制对象的访问。
 */
public class SampleClass {

    public void test() {
        System.out.println("hello world.");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return result;
            }
        });
        SampleClass sample = (SampleClass)enhancer.create(); // 用来创建增强对象的
        sample.test();
    }

    // 测试Enhancer
    @Test
    public void testFixedValue() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class); // 用来设置父类型；使用CGLib生成的类为被代理类的一个子类
        enhancer.setCallback(new FixedValue() { // FixedValue() 用来对所有拦截的方法返回相同的值
            @Override
            public Object loadObject() throws Exception {
                return "hello cglib";
            }
        });
        SampleClass proxy = (SampleClass)enhancer.create();
        proxy.test(); // 对test进行了拦截
        System.out.println(proxy.toString()); // 对toString方法进行了拦截
        System.out.println(proxy.getClass()); // Enhancer不对 final方法进行拦截
        System.out.println(proxy.hashCode()); // 由于hashCode()方法需要返回一个Number, 但是我们返回的是String，因此报错
    }

    @Test
    // 测试InvocationHandler
    // 使用一个InvocationHandler作为回调，使用invoke方法来替换直接访问类的方法，但是需注意死循环。
    // invoke中调用的任何原代理类方法，均会重新代理到invoke方法中。
    public void testInvocationHandler() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "hello cglib";
                } else {
                    throw new RuntimeException("Do not know what to do");
                }

            }
        });

        SampleClass proxy = (SampleClass)enhancer.create();
        //Assert.assertEquals("hello cglib", proxy.test());
        Assert.assertEquals("Hello cglib", proxy.toString());
    }

    // 测试仅对特定方法进行拦截
    @Test
    public void testCallbackFilter() {
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "Hello cglib";
                        }
                    };
                } else {
                    return NoOp.INSTANCE;
                }

            }
        };
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter( callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass) enhancer.create();
        Assert.assertNotEquals("Hello cglib", proxy.toString());
        System.out.println(proxy.hashCode());
    }

    // ImmutableBean; 允许创建一个原来对象的包装类，这个包装类是不可变的
    // 但是可以通过直接操作底层对象来改变包装类对象
    @Test(expected = IllegalStateException.class)
    public void testImmutableBean() {
        SampleBean bean = new SampleBean();
        bean.setValue("Hello World");
        // 创建不可变类
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean);
        Assert.assertEquals("Hello World", immutableBean.getValue());
        bean.setValue("Hello World, again"); // 可通过底层对象来进行修改
        Assert.assertEquals("Hello World, again", immutableBean.getValue());
        immutableBean.setValue("Hello cglib"); // 直接修改将throw Exception
    }

    // Bean generator; cglib提供的一个操作bean的工具，使用它能够在运行时动态的创建一个bean
    @Test
    public void testBeanGenerator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value", String.class);
        Object myBean = beanGenerator.create();
        // Class.getMethod(String name, Class<?>...types) 第一个参数是要获得的方法的名字，第二个参数是按声明顺序标识该方法的形参类习惯
        Method setter = myBean.getClass().getMethod("setValue", String.class);
        setter.invoke(myBean, "Hello cglib");

        Method getter = myBean.getClass().getMethod("getValue");
        Assert.assertEquals("Hello cglib", getter.invoke(myBean));
    }






}
