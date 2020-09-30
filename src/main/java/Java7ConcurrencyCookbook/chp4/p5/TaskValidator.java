package Java7ConcurrencyCookbook.chp4.p5;

import java.util.concurrent.Callable;

/**
 * 实现了带有String 泛型参数的Callable接口
 */
public class TaskValidator implements Callable<String> {
    private UserValidator validator;
    private String user;
    private String password;

    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception{
        if (!validator.validate(user, password)){
            System.out.printf("%s: The user has not been fount\n, validator.getName()");
            throw new Exception("Error validating user");
        }
        System.out.printf("%s: The user has been found\n", validator.getName());
        return validator.getName();
    }
}
