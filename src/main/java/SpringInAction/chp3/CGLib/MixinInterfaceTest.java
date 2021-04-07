package SpringInAction.chp3.CGLib;

import net.sf.cglib.proxy.Mixin;
import org.junit.Assert;
import org.junit.Test;

// Mixin （混合）
// 能够让我们将多个对象整合到一个对象中区，前提是这些对象是接口的实现
public class MixinInterfaceTest {

    interface Interface1{
        String first();
    }
    interface Interface2{
        String second();
    }
    class Class1 implements Interface1{
        @Override
        public String first() {
            return "first";
        }
    }

    class Class2 implements Interface2 {
        @Override
        public String second() {
            return "second";
        }
    }

    interface MixinInterface extends Interface1, Interface2 {}

    @Test
    public void testMixin() {
        // create() 方法的参数分别为：接口的class对象，对应的实现的class对象
        Mixin mixin = Mixin.create(new Class[]{Interface1.class, Interface2.class,
                                MixinInterface.class}, new Object[]{new Class1(), new Class2()});
        MixinInterface mixinDelegate = (MixinInterface) mixin;
        Assert.assertEquals("first", mixinDelegate.first());

    }
}
