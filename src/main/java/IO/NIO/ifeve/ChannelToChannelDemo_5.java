package IO.NIO.ifeve;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelToChannelDemo_5 {

    /**
     * 参数position表示：从position处开始向目标文件写入数
     *
     *
     * count表示最多传入的字节数；
     * 如果源通道的剩余空间小于 count 个字节，则所传输的字节数要小于请求的字节数。
     *
     *
     *此外要注意，在SoketChannel的实现中，
     * SocketChannel只会传输此刻准备好的数据（可能不足count字节）。
     * 因此，SocketChannel可能不会将请求的所有数据(count个字节)
     * 全部传输到FileChannel中。
     * @throws IOException
     */

    public  static void demo_TransferFrom() throws IOException {

        RandomAccessFile fileFrom = new RandomAccessFile("tinyT.txt", "rw");
        FileChannel fromChannel = fileFrom.getChannel();


        RandomAccessFile fileTo = new RandomAccessFile("tinyTo.txt", "rw");
        FileChannel toChannel = fileTo.getChannel();

        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel, position, count);
    }

    /**
     * SocketChannel会一直传输数据直到目标buffer被填满。
     * @throws IOException
     */
    public static void demo_TransferTo() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("tinyT.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("tinyTo.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();
        fromChannel.transferTo(position, count, toChannel);
    }

    public static void main(String[] args) throws IOException {
        //demo_TransferFrom();
        demo_TransferTo();
    }
}
