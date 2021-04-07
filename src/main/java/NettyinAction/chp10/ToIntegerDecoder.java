package NettyinAction.chp10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ToIntegerDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        // 检查是否至少有4字节可读 （一个 int  的字节长度）
        if (byteBuf.readableBytes() >= 4) {
            // 从入站 ByteBuf 中读取一个 int， 并将其添加到解码消息的 List 中
            out.add(byteBuf.readInt());
        }
    }
}
