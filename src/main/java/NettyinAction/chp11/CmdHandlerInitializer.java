package NettyinAction.chp11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

/**
 * 代码清单11-9 使用ChannelInitializer 安装解码器
 */
public class CmdHandlerInitializer extends ChannelInitializer<Channel> {
    final byte SPACE = (byte)' ';

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        // 1. 添加 CmdDecoder 以提取 Cmd 对象，并将它转发给下一个ChannelInboundHandler
        pipeline.addLast(new CmdDecoder(64 * 1024));
        // 2. 添加 CmdHandler 以接收和处理Cmd对象
        pipeline.addLast(new CmdHandler());
    }
}
