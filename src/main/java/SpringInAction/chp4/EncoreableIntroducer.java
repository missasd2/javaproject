package SpringInAction.chp4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "SpringInAction.chp4.Performance+",
    defaultImpl = DefaultEncoreable.class
    )
    public static Encoreable encoreable;
}
