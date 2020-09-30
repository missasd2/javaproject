package Java7ConcurrencyCookbook.chp4.p5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String username = "test";
        String password = "test";

        UserValidator ldap = new UserValidator("LDAP");
        UserValidator db = new UserValidator("DB");
        TaskValidator ldapTask = new TaskValidator(ldap, username, password);
        TaskValidator dbTask = new TaskValidator(db, username, password);

        List<TaskValidator> taskList =  new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);

        ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
        String result;

        try {
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n", result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 终止执行器
        executor.shutdown();
        System.out.printf("Main: End of the Execution \n");
    }
}
