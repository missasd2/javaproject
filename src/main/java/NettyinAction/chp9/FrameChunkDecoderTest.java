package NettyinAction.chp9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.TooLongFrameException;
import org.junit.Assert;
import org.junit.Test;

/**
 * 代码清单9-6 测试
 */
public class FrameChunkDecoderTest {

    @Test
    public void testFramesDecoded() {
        ByteBuf buf = Unpooled.buffer(); // 1. 创建一个ByteBuf，并向它写入9字节
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        ByteBuf input = buf.duplicate();

        // 创建一个EmbeddedChannel，并向其安装一个帧大小为3 字节的FixedLengthFrameDecoder
        EmbeddedChannel channel = new EmbeddedChannel(new FrameChunkDecoder(3));
        // 3. 向它写入2字节，并断言它们将会产生一个新帧
        Assert.assertTrue(channel.writeInbound(input.readBytes(2)));
        // 4. 如果上面没有抛出异常，那么就会达到这个断言，并且测试失败
        try {
            channel.writeInbound(input.readBytes(4)); // 5. 写入一个4字节大小的帧，并捕获预期的TooLongFrameException
            Assert.fail();
        } catch (TooLongFrameException e) {

        }
        // 6. 写入剩余的2字节，并断言将会产生一个有效帧
        Assert.assertTrue(channel.writeInbound(input.readBytes(3)));
        Assert.assertTrue(channel.finish()); // 将channel标记为已完成状态

        // read bytes; 读取产生的消息，并验证值
        ByteBuf read = (ByteBuf)channel.readInbound();
        Assert.assertEquals(buf.readSlice(2), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.skipBytes(4).readSlice(3), read);
        read.release();
        buf.release();


    }
}
