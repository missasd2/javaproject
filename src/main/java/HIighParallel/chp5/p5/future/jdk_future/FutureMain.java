package HIighParallel.chp5.p5.future.jdk_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 构造FutureTask对象实例
        FutureTask<String> future = new FutureTask<>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // 执行FutureTask,相当于上例中的client.request("a")发送请求
        // 在这里开启线程进行RealData的call()方法执行
        // 将FutureTask提交给线程池
        executor.submit(future);
        System.out.println("请求完毕");
        try {
            // 这里依然可以做额外的数据操作，使用sleep代替其他业务逻辑的处理
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        // 相当于5.5.2 节中的data.getResult()方法，取得call()方法的返回值
        // Future.get()方法得到Future的处理结果，但是这个方法是阻塞的
        System.out.println("数据= " + future.get());
    }
}
