package jcip.chp5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

/**
 * 程序清单5-12 使用FutureTask 来提前加载稍后需要的数据
 */
public class Preloader {
    private final FutureTask<ProductInfo> future =
            new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
                @Override
                public ProductInfo call() throws Exception {
                    return loadProductInfo();
                }
            });
    private final Thread thread = new Thread(future);

    public void start() { thread.start(); }

    public ProductInfo loadProductInfo(){
        return (ProductInfo) new Object();
    }

    public ProductInfo get() {
        try {
            return future.get();
        }
        catch (ExecutionException | InterruptedException e) {
            Throwable cause = e.getCause();
            throw launderThrowable(cause);
        } finally {
            return (ProductInfo) new Object();
        }
    }

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        }else {
            throw new IllegalStateException("Not unchecked ", t);
        }
    }


}
