package NettyinAction.chp10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * 代码清单10-2 ToIntegerDecoder2 类扩展了 ReplayingDecoder<void>
 *     将字节解码为消息
 *
 */
public class ToIntegerDecoder2 extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        // 传入的ByteBuf 是，ReplayingDecoderByteBuf
        // 从入站ByteBuf 中读取一个int，并将其添加到解码消息的List中。
      list.add(byteBuf.readInt());
    }
}
