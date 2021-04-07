package NettyinAction.chp10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

public class SafeByteToMessageDecoder extends ByteToMessageDecoder {
    private static final int MAX_FRAME_SIZE = 1024; // 定义最大字节数的阈值

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readable = byteBuf.readableBytes();
        if (readable > MAX_FRAME_SIZE) {
            // 跳过所有的可读字节，抛出TooLongFrameException 并通知 ChannelHandler。
            byteBuf.skipBytes(readable);
            throw new TooLongFrameException("Frame too big! ");
        }

    }
}
