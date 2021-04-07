package jcip.annotate;

import java.lang.annotation.*;

@Documented // 表明这个注解应该被 javadoc工具记录
@Target(ElementType.TYPE) // 设定注解使用范围是类型上
@Retention(RetentionPolicy.RUNTIME) // 设定生命周期位全周期，支持使用反射机制的代码读取和使用
public @interface NotThreadSafe {
}
