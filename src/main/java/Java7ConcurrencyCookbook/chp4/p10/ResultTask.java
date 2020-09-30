package Java7ConcurrencyCookbook.chp4.p10;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {

   private String name;
   public ResultTask(Callable<String> callable){
       super(callable);
       this.name = ((ExecutableTask) callable).getName();
   }

   // done()方法。检查isCancelled()方法的返回值，根据返回值在控制台输出不同的信息；
    @Override
    public void done() {
       if (isCancelled()){
           System.out.printf("%s: Has been canceled \n", name);
       }else {
           System.out.printf("%s, Has finished \n", name);
       }

    }
}
