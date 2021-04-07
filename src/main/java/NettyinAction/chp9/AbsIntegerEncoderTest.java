package NettyinAction.chp9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

/**
 * 代码清单9-4 测试AbsIntegerEncoder
 */
public class AbsIntegerEncoderTest {
    @Test
    public void testEncoded() {
        // 1. 创建一个ByteBuf，并且写入9个负整数
        ByteBuf buf = Unpooled.buffer();
        for (int i = 1; i < 10; i++) {
            buf.writeInt(i * -1);
        }
        // 2. 创建一个 EmbeddedChannel，并安装一个要测试的AbsIntegerEncoder
        EmbeddedChannel channel = new EmbeddedChannel(new AbsIntegerEncoder());
        // 3. 写入ByteBuf，并断言调用readOutbound（）方法将会产生数据
        Assert.assertTrue(channel.writeOutbound(buf));
        // 4. 将该Channel标记为已完成状态
        Assert.assertTrue(channel.finish());
        // read bytes; 5. 读取所产生的消息，并断言它们包含了对应的绝对值
        for (int i = 1; i < 10; i++) {
            Assert.assertEquals(i, (int)channel.readOutbound());
        }
        Assert.assertNull(channel.readOutbound());

    }
}
