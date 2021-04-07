package SpringInAction.chp4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 4.3.2 创建环绕通知
 */
@Aspect
public class Audience_Around {

    @Pointcut("execution(**SpringInAction.chp4.Performance.perform())")
    public void performance() { }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            // 在perform方法执行之前，调用下列
            System.out.println("Silencing cell phones ");
            System.out.println("Taking seats ");
            jp.proceed();
            // 在perform方法执行之后，调用下列
            System.out.println("CLAP CLAP CLAP");
        } catch (Throwable throwable) {
            // 在perform方法执行失败后，调用下列
            throwable.printStackTrace();
            System.out.println("Demanding a refund");
        }
    }

}
