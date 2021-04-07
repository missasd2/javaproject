package NettyinAction.chp13;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.MessageToMessageEncoder;


import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 代码清单13-2 LogEventEncoder
 */
public class LogEventEncoder extends MessageToMessageEncoder<LogEvent> {
    private final InetSocketAddress remoteAddress;

    // LogEventEncoder 创建了即将被发送到指定的InetSocketAddress 的DatagramPacket 消息
    public LogEventEncoder(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, LogEvent logEvent, List<Object> list) throws Exception {
        // 日志文件名称的字节序列
        byte[] file = logEvent.getLogfile().getBytes(StandardCharsets.UTF_8);
        // 消息内容的字节序列
        byte[] msg = logEvent.getMsg().getBytes(StandardCharsets.UTF_8);
        ByteBuf buf = ctx.alloc().buffer(file.length + msg.length + 1);
        buf.writeBytes(file);
        buf.writeByte(LogEvent.SEPARATOR); // 添加一个SEPARATOR
        buf.writeBytes(msg); // 将日志消息写入ByteBuf中
        // 将一个拥有数据 和 目的地址的新DatagramPacket添加到出站的消息列表中
        list.add(new DatagramPacket(buf, remoteAddress));
    }
}
