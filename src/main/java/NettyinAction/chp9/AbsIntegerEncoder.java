package NettyinAction.chp9;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 代码清单 9-3 AbsIntegerEncoder
 * 扩展 MessageToMessageEncoder 以将一个消息编码为另外一种格式
 */
public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf>{

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        // 检查是否有足够的字节用来编码
        while (byteBuf.readableBytes() >= 4) {
            // 从输入的ByteBuf 中读取下一个整数，并且计算其绝对值
            int value = Math.abs(byteBuf.readInt());
            // 将该整数写入到编码消息的 List中
            list.add(value);
        }
    }
}
