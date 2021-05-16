package JavaSE.Collection;

import org.jboss.arquillian.container.impl.ThreadContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
测试Collection接口的fail-fast机制，以ArrayList为例
 */
public class FailFast {

    private static List<Integer> list = new ArrayList<>();

    private static class ThreadOne extends  Thread{

        @Override
        public void run() {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                int i = iterator.next();
                System.out.println("ThreadOne 遍历: " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadTwo extends Thread{
        @Override
        public void run() {
            int i = 0;
            while (i < 6) {
                System.out.println("ThreadTwo run: " + i);
                if ( i == 3) {
                    list.remove(i);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        new ThreadOne().start();
        new ThreadTwo().start();
    }
}
