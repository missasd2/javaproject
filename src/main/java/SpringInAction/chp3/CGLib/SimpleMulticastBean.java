package SpringInAction.chp3.CGLib;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.cglib.reflect.ConstructorDelegate;
import org.springframework.cglib.reflect.FastClass;
import org.springframework.cglib.reflect.FastMethod;
import org.springframework.cglib.reflect.MulticastDelegate;
import org.springframework.cglib.util.ParallelSorter;

import java.lang.reflect.InvocationTargetException;

public class SimpleMulticastBean implements DelegationProvider{
    private String value;

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // 多重代理和方法代理差不多，都是将代理方法的调用委托给代理类。
    // 使用前提是需要一个接口，以及一个类实现了该接口。
    @Test
    public void testMulticastDelegate() {
        MulticastDelegate multicastDelegate = MulticastDelegate.create(DelegationProvider.class);
        SimpleMulticastBean first = new SimpleMulticastBean();
        SimpleMulticastBean second = new SimpleMulticastBean();
        // 2. 通过这种interface的继承关系，能够将接口上方法的调用分散给各个实现类上面区
        // 3. 多重代理的缺点是：接口只能含有一个方法，如果被代理的方法拥有返回值，则调用代理类的返回值为最后一个添加的被代理类的方法返回值
        multicastDelegate = multicastDelegate.add(first);
        multicastDelegate = multicastDelegate.add(second);

        DelegationProvider provider = (DelegationProvider) multicastDelegate;
        provider.setValue("Hello world");

        Assert.assertEquals("Hello world", first.getValue());
        Assert.assertEquals("Hello world", second.getValue());

    }
    // Constructor delegate

    interface SampleBeanConstructorDelegate {
        Object newInstance(String value);
    }
    /**
     * 对构造函数进行代理, 需要一个接口，这个接口只有一个 Object newInstance() 方法，用来调用相应的构造函数
     */
    @Test
    public void testConstructorDelegate() {
        SampleBeanConstructorDelegate constructorDelegate =
        (SampleBeanConstructorDelegate) ConstructorDelegate.create(SampleBean.class, SampleBeanConstructorDelegate.class);
        SampleBean bean = (SampleBean) constructorDelegate.newInstance("Hello world");
        Assert.assertTrue(SampleBean.class.isAssignableFrom(bean.getClass()));
        System.out.println(bean.getValue());
    }

    // Parallel Sorter 并行排序器
    // 能够对多个数组同时进行排序，目前实现的算法有归并和快排
    @Test
    public void testParallelSorter() {
        Integer[][] value = {
                {4, 3, 9, 0},
                {2, 1, 6, 0}
        };
        ParallelSorter.create(value).mergeSort(0);
        for (Integer[] row : value) {
            int former = -1;
            for (int val : row) {
                Assert.assertTrue(former < val);
                former = val;
            }
        }
    }

    // FastClass
    @Test
    public void testFastClass() throws InvocationTargetException {
        FastClass fastClass = FastClass.create(SampleBean.class);
        FastMethod fastMethod = fastClass.getMethod("getValue", new Class[0]);
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        Assert.assertEquals("Hello world", fastMethod.invoke(bean, new Object[0]));
    }
}
