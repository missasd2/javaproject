package SpringInAction.chp3.CGLib;

import SevenWeekSevenCon.chp2.p2.Calculate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.asm.Type;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cglib.beans.BulkBean;
import org.springframework.cglib.core.KeyFactory;
import org.springframework.cglib.core.Signature;
import org.springframework.cglib.proxy.InterfaceMaker;
import org.springframework.cglib.reflect.MethodDelegate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * CGLib 提供的能够从一个bean复制到另一个bean中，且提供了一个转化器，用来在转换的时候对bean的属性进行操作
 * Bean Copieer
 */
public class OtherSampleBean {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Test
    public void testBeanCopier() {
        BeanCopier copier = BeanCopier.create(SampleBean.class, OtherSampleBean.class, false);// 若设置为true，则使用converter
        SampleBean myBean = new SampleBean();
        myBean.setValue("Hello cglib");
        OtherSampleBean otherBean = new OtherSampleBean();
        copier.copy(myBean, otherBean, null); // 若上面的create（）方法中第三个参数为true，则这里需传入converter指明怎么进行转换
        Assert.assertEquals("Hello cglib", otherBean.getValue());
    }

    // BulkBean将copy的动作划分为getPropertyValues和setPropertyValues两个方法
    // 允许自定义处理属性
    @Test
    public void testBulkBean() {
        BulkBean bulkBean = BulkBean.create(SampleBean.class,
                new String[]{"getValue"},
                new String[]{"setValue"},
                new Class[]{String.class});
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        // 获取属性
        Object[] propertyValues = bulkBean.getPropertyValues(bean);
        Assert.assertEquals(1, bulkBean.getPropertyValues(bean).length);
        Assert.assertEquals("Hello world", bulkBean.getPropertyValues(bean)[0]);
        // 完成bulkBena的属性设置
        bulkBean.setPropertyValues(bean, new Object[]{"Hello cglib"});
        Assert.assertEquals("Hello cglib", bean.getValue());
    }

    // 将一个bean对象中的所有属性转换为一个 String-to-Object 的Java Map
    @Test
    public void testBeanMap() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator generator = new BeanGenerator();
        generator.addProperty("username", String.class);
        generator.addProperty("password", String.class);
        // 1. 获得一个带有属性的bean对象
        Object bean = generator.create();
        // 2. 获得方法对象
        Method setUsername = bean.getClass().getMethod("setUsername", String.class);
        Method setPassword = bean.getClass().getMethod("setPassword", String.class);
        // 3. 调用方法
        setUsername.invoke(bean, "admin");
        setPassword.invoke(bean, "password");
        // 4. 生成BeanMap对象
        BeanMap map = BeanMap.create(bean);
        Assert.assertEquals("admin", map.get("username"));
        Assert.assertEquals("password", map.get("password"));
    }

    // keyFactory 用来动态生成接口的实例
    // keyFactory 为构造出来的动态实例生成了Object.equals() 和 Object.hashCode() 方法，
    //      确保相同的参数构造出来的实例为单例的
    @Test
    public void testKeyFactory() {
        SampleKeyFactory keyFactory = (SampleKeyFactory) KeyFactory.create(SampleKeyFactory.class);
        Object key = keyFactory.newInstance("foo", 42);
        Object key2 = keyFactory.newInstance("foo", 42);
        Assert.assertEquals(key, key2);
    }

    // Interface Maker
    @Test
    public void testInterfaceMaker() {
        // 创建接口中方法的签名。签名为double foo(int)
        // 接口仅仅只用作在编译期进行类型检查,因此在一个运行的应用中动态的创建接口没有什么作用
        Signature signature = new Signature("foo", Type.DOUBLE_TYPE, new Type[]{Type.INT_TYPE});
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(signature, new Type[0]);
        Class iface = interfaceMaker.create();
        Assert.assertEquals(1, iface.getMethods().length);
        Assert.assertEquals("foo", iface.getMethods()[0].getName());
        Assert.assertEquals(double.class, iface.getMethods()[0].getReturnType());
    }

    // Method delegate
    interface BeanDelegate {
        String getValueFromDelegate();
    }

    @Test
    public void testMethodDelegate() {
        SampleBean bean = new SampleBean();
        bean.setValue("Hello cglib");
        // 第一个参数为无参构造的bean，第二个参数为即将被代理的方法，第三个参数为只含一个方法的接口，当这个接口中的方法被调用的时候，将会调用第一个参数所代表的bean的第二个参数的方法
        // 对应本例则为 调用 bean的 getValue方法
        BeanDelegate delegate = (BeanDelegate) MethodDelegate.create(bean, "getValue", BeanDelegate.class);
        Assert.assertEquals("Hello cglib", delegate.getValueFromDelegate());
    }

    // MulticastDelegate


}
