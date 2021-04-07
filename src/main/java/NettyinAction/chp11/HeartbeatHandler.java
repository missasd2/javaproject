package NettyinAction.chp11;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

public class HeartbeatHandler extends ChannelInboundHandlerAdapter {
    // 1. 定义发送到远程节点的心跳消息
    private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer
            ("HEARTBEAT", CharsetUtil.ISO_8859_1));
    // 2. 实现userEventTriggered()方法以发送心跳消息
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            // 3. 发送心跳消息，并在发送失败时关闭该连接
            ctx.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        } else {
            // 4. 不是IdleStateEvent事件，所以将它传递给下一个ChannelInboundHandler
            super.userEventTriggered(ctx, evt);
        }
    }
}
