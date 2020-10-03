package IO.NIO.chp1.Buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo1 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("tinyT.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        // 分配一个48字节的capacity的ByteBuffer的例子
        ByteBuffer buf = ByteBuffer.allocate(48);
        // 从Channel写到Buffer
        int byteRead = inChannel.read(buf);

        while (byteRead != -1){

            // 将Buffer从写模式切换到读模式。
            // 调用flip方法会将position设回0，并将limit设置成之前position的值
            buf.flip(); // make buffer ready for read

            while (buf.hasRemaining()){
                // 使用get()方法从Buffer中读取数据
                System.out.println((char)buf.get()); // read 1 byte at a time
            }
            // clear()方法，position将被设回0，
            buf.clear(); // make buffer ready for writing
            byteRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
