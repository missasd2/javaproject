package NettyinAction.chp9;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

/**
 * 代码清单 9-5 FrameChunkDecoder
 */
public class FrameChunkDecoder extends ByteToMessageDecoder {
    private final int maxFrameSize;

    public FrameChunkDecoder(int maxFrameSize) {
        this.maxFrameSize = maxFrameSize;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        // 帧的大小超过 最大允许大小
        if (readableBytes > maxFrameSize) {
            byteBuf.clear(); // 则将该帧丢弃，并抛出一个TooLongFrameException
            throw new TooLongFrameException();
        }
        ByteBuf buf = byteBuf.readBytes(readableBytes); // 否则，从ByteBuf中读取一个新的帧
        list.add(buf); // 将该帧添加到解码消息的List中
    }
}
