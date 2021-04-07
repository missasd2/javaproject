package NettyinAction.chp13;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * 代码清单13-6 LogEventDecoder, 是ChannelPipeline中的第一个handler，
 * 用于将DatagramPacket 解码为 LogEvent 消息
 */
public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {

    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        // 1. 获取对 DatagramPacket中的数据 （ByteBuf）的引用
        ByteBuf data = datagramPacket.content();
        // 2. 获取该 SEPARATOR 的索引
        int idx = data.indexOf(0, data.readableBytes(), LogEvent.SEPARATOR);
        // 3. 提取文件名
        String filename = data.slice(0, idx).toString(CharsetUtil.UTF_8);
        // 4. 提取日志消息
        String logMsg = data.slice(idx + 1, data.readableBytes()).toString(CharsetUtil.UTF_8);
        // 5. 构建一个新的LogEvent对象，并且将它添加到（已经解码的消息的）列表中
        LogEvent event = new LogEvent(datagramPacket.sender(), System.currentTimeMillis(), filename, logMsg);
        list.add(event);
    }
}
