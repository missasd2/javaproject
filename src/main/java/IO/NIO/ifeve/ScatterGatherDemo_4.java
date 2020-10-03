package IO.NIO.ifeve;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Scatter 分散读，是以Channel的角度来看待的，
 *分散读，是指数据从一个channel读取到多个Buffer中；
 */
public class ScatterGatherDemo_4 {

    public static void main(String[] args) throws IOException {


    }

    public void testScatter() throws IOException {
        RandomAccessFile file = new RandomAccessFile("tinyT.txt", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};

        channel.read(bufferArray);
    }

    /**
     * buffers数组是write()方法的入参，
     * write()方法会按照buffer在数组中的顺序，将数据写入到channel，
     * @throws IOException
     */
    public void testGather() throws IOException {
        RandomAccessFile file = new RandomAccessFile("tinyT.txt", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};
        channel.write(bufferArray);
    }
}
