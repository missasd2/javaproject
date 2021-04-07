package NettyinAction.chp10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 代码清单10-9
 */
public class CharToByteEncoder extends MessageToByteEncoder<Character> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Character msg, ByteBuf byteBuf) throws Exception {
        byteBuf.writeChar(msg); // 将Character解码为char，并将其写入到出站 ByteBuf中
    }
}
