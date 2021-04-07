package NettyinAction.chp10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码清单 10-3 MessageToByteEncoder
 * 编码器 针对出站数据
 */
public class ShortToByteEncoder extends MessageToByteEncoder<Short> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Short msg, ByteBuf byteBuf) throws Exception {
        byteBuf.writeShort(msg);
    }
}
