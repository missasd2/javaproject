package Java7ConcurrencyCookbook.chp1.p9;

/**
 * 通过实现UncaughtExceptionHandler接口，并重写uncaughtException方法
 *
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.println("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n", t.getState());
    }
}
