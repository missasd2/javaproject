package IO.NIO.chp1.p1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo1 {
    public static void main(String[] args) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("tinyT.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            // 定义一个48byte的ByteBuffer，初始值为0，初始偏移为0
            ByteBuffer buf = ByteBuffer.allocate(48);

            // 从Channel读byte到指定的buffer中，返回值是在文件中的位置
            int byteRead = inChannel.read(buf);
            while (byteRead != -1){
                System.out.println("Read " + byteRead);
                // 首先读取数据到Buffer，然后反转Buffer，接着再从Buffer中读取数据
                buf.flip();

                while (buf.hasRemaining()){
                    System.out.println((char)buf.get());
                }
                buf.clear();
                byteRead = inChannel.read(buf);

            }
            aFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
