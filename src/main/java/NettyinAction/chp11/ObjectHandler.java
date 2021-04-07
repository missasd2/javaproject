package NettyinAction.chp11;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.Serializable;

/**
 * 代码清单11-13
 * 添加ObjectHandler，以处理普通的实现了Serializable接口的POJO
 */
public class ObjectHandler extends SimpleChannelInboundHandler<Serializable> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Serializable serializable) throws Exception {
        // Do something
    }
}
