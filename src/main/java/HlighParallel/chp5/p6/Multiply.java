package HlighParallel.chp5.p6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * P2 计算的是乘法
 */
public class Multiply  implements Runnable{
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<Msg>();

    @Override
    public void run() {
        while (true){
            try {
                Msg msg = bq.take();
                msg.i = msg.i * msg.j;
                Div.bq.add(msg);
            }catch (InterruptedException e){

            }
        }
    }
}
