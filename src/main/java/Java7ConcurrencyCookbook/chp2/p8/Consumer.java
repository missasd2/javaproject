package Java7ConcurrencyCookbook.chp2.p8;

import java.util.Random;

public class Consumer implements Runnable{

    private Buffer buffer;
    public Consumer (Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()){
            String line = buffer.get();
            processLine(line);
        }
    }

    // 辅助方法 processLine 用于模拟休眠10毫秒以对模拟数据行的处理
    private void processLine(String line){
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
