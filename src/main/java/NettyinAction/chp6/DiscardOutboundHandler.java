package NettyinAction.chp6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

/**
 * 代码清单6-4 丢弃并释放出站消息
 */
@ChannelHandler.Sharable // 表明该Handler 可被多个Channel共享
public class DiscardOutboundHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ReferenceCountUtil.release(msg); // 通过release方法释放资源
        promise.setSuccess(); // 通知ChannelPromise 数据已经被处理了
    }

}
