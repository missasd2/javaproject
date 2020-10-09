package Concurrent.Beauty.chp4.p3;

/**
 * ThreadLocal提供了线程本地变量,变量类型支持泛型
 */
public class ThreadLocalTest {
    //
    static void print(String str){
        System.out.println(str + " : " + localVariable.get());
        // localVariable.remove();
    }
    static ThreadLocal<String> localVariable = new ThreadLocal<>();
    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                // set()方法设置的是线程One本地内存中的一个副本，这个副本，线程Two是访问不了的。
                // 给当前线程关联这个线程本地变量localVariable
                localVariable.set("threadOne local variables");
                // 覆盖线程本地变量的值
                localVariable.set("hello");
                // 给当前线程再关联一个本地线程变量local
                local.set("world");
                print("threadOne");
                // get()方法获取的是当前线程本地变量的值；
                System.out.println("threadOne remove after : " + localVariable.get());
                System.out.println(localVariable.get() + " " +  local.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("threadTwo remove after : " + localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }


}
