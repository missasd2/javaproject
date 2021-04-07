package NettyinAction.chp11;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 *
 * 从被重写了的decode()方法中获取一行字符串，并从它的内容构建一个Cmd的实例
 */
public class CmdDecoder extends LineBasedFrameDecoder {
    final byte SPACE = (byte) ' ';

    public CmdDecoder(int maxLength) {
        super(maxLength);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        // 从ByteBuf 中提取由行尾符序列分隔的帧
        ByteBuf frame = (ByteBuf)super.decode(ctx, buffer);
        if (frame == null) {
            return null; // 如果输入中没有帧，则返回null
        }
        // 查找第一个空格字符的索引，前面是命令名称，接着是参数
        int index = frame.indexOf(frame.readerIndex(), frame.writerIndex(), SPACE);
        // 使用包含有命令名称 和 参数的切片，创建新的Cmd对象。
        return new Cmd(frame.slice(frame.readerIndex(), index), frame.slice(index + 1, frame.writerIndex()));
    }


}
