package Concurrent.Beauty.chp4.p3;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 4.3.4 管道输入/输出流
 * 管道输入/输出流主要包括了如下4种具体实现：
 * PipedOutputStream、PipedInputStream、
 * PipedReader和PipedWriter，
 * 前两种面向字节，而后两种面向字符。
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();// 面向字符
        PipedReader in = new PipedReader();  // 面向字符
        // 将输入流和输出流进行连接，否则再使用时会抛出IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1){
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }

    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }
        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1){
                    System.out.print((char)receive);
                }
            }catch (IOException e){

            }
        }
    }
}
