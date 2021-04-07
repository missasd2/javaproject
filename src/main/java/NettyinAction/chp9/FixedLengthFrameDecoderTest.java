package NettyinAction.chp9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

public class FixedLengthFrameDecoderTest {

    @Test
    public void testFramesDecoded() {
        // 1.创建一个ByteBuf，并存储9字节
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 5; i++) {
            buf.writeByte(i);
        }
        //
        ByteBuf input = buf.duplicate();
        // 2. 创建一个EmbeddedChannel，并添加一个FixedLengthFrameDecoder，并将其以3字节的帧长度被测试
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        // write bytes; 将数据写入 EmbeddedChannel
        Assert.assertTrue(channel.writeInbound(input.retain()));
        // 标记Channel 为已完成状态
        Assert.assertTrue(channel.finish());

        // read bytes; 读取所生成的消息，并且验证是否有3帧（切片），其中每帧（切片）都为3字节
        ByteBuf buf1 = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3), buf1);
        buf1.release();

        buf1 = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3), buf1);
        buf1.release();

        buf1 = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3), buf1);
        buf1.release();

        Assert.assertNull(channel.readInbound());
        buf.release();
    }

    @Test
    public void testFramesDecoded2() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        Assert.assertFalse(channel.writeInbound(input.readBytes(2))); // 返回false，因为没有一个完整的可供读取的帧
        Assert.assertTrue(channel.writeInbound(input.readBytes(7)));

        Assert.assertTrue(channel.finish());
        ByteBuf read = (ByteBuf)channel.readInbound();
        Assert.assertEquals(buf.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3), read);
        read.release();

        Assert.assertNull(channel.readInbound());
        buf.release();
    }
}
