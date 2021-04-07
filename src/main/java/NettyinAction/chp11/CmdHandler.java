package NettyinAction.chp11;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
/**
 * 代码清单11-9 使用ChannelInitializer安装解码器
 * CmdHandler:  从CmdDecoder 获取解码的 Cmd对象，并对它进行一些处理
 */
public class CmdHandler extends SimpleChannelInboundHandler<Cmd> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Cmd cmd) throws Exception {
        // 处理传经 ChannelPipeline 的Cmd 对象
    }
}
