package SpringInAction.chp4;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

@Aspect
public class AudiencePointCut {

    @Pointcut("execution(**SpringInAction.chp4.Performance.perform(..))") // 定义可重用切入点
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats ");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund ");
    }

    @Bean
    public AudiencePointCut audiencePointCut() { // 该类可以装配为Spring中的bean
        return new AudiencePointCut();
    }
}
