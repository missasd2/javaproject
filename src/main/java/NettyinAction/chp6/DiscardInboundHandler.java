package NettyinAction.chp6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * 代码清单6-3 消费并释放入站消息
 */
public class DiscardInboundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        // 通过调用 release 方法释放资源。
        ReferenceCountUtil.release(msg);
    }
}
