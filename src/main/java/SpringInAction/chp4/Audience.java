package SpringInAction.chp4;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Audience类：观看演出的切面
 */
@Aspect // 该注解表明这个类不仅仅是一个POJO，也是一个切面
public class Audience {

//    @Before("execution(** SpringInAction.chp4.Performance(..)")

    // 通知：定义了切面要完成的工作（方法），在何时执行这个工作（@Before、@Around、@After、@AfterReturning、@AfterThrowing）
    // 定义切点表达式，在方法执行之前
    @Before("execution(**SpringInAction.chp4.Performance.perform(..))") // 切点表达式：会匹配通知所要植入的一个或多个连接点
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("execution(**SpringInAction.chp4.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking seats ");
    }

    @AfterReturning("execution(**SpringInAction.chp4.Performance.perform(..))") // 在目标方法成功执行之后，调用通知
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!"); // 表演之后
    }

    @AfterThrowing("execution(**SpringInAction.chp4.Performance.perform(..))") // 在目标方法抛出异常之后，调用通知
    public void demandRefund() {
        System.out.println("Demanding a refund"); // 表演失败之后
    }





}
