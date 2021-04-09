package jcip.annotate;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) //表示注解的生命周期
public @interface Immutable {
}
