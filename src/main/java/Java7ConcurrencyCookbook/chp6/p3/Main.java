package Java7ConcurrencyCookbook.chp6.p3;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>();

        Client client = new Client(list);

        // 开启添加线程
        Thread thread = new Thread(client);
        thread.start();

        // 使用list的take()方法，每300毫秒从列表中取出3个字符串对象，重复5次
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                String request = list.take();
                System.out.printf("Main: Request: %s at %s. Size: %d \n", request, new Date(), list.size());
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }

        System.out.printf("Main: End of the program. \n");
    }
}
