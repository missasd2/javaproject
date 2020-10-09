package IO.NIO.ifeve;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo_7 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("tinyT.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        //
        // 从FileChannel读取的数据将被读到Buffer中
        ByteBuffer buf = ByteBuffer.allocate(48);
        // read()方法表示有多少字节被读到了Buffer中。如果返回-1，表示到了文件末尾
        int bytesRead = inChannel.read(buf);

        while (bytesRead != -1){
            System.out.println("Read " + bytesRead);
            // flip()方法将Buffer从写模式转换为读模式
            buf.flip();

            while (buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            // 将Buffer清空，然后继续从Channel读数据到Buffer
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
