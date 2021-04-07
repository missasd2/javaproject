package NettyinAction.chp6;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

import static NettyinAction.chp6.DummyChannelHandlerContext.DUMMY_INSTANCE;

/**
 * 代码清单6-6 从ChannelHandlerContext 访问 Channel
 */
public class WriteHandlers {
    private static final ChannelHandlerContext CHANNEL_HANDLER_CONTEXT_FROM_SOMEWHERE = DUMMY_INSTANCE;
    private static final ChannelPipeline CHANNEL_PIPELINE_FROM_SOMEWHERE = DummyChannelPipeline.DUMMY_INSTANCE;

    /**
     * 代码清单6-6 从ChannelHandlerContext 访问 Channel
     */
    public static void writeViaChannel() {
        ChannelHandlerContext ctx = CHANNEL_HANDLER_CONTEXT_FROM_SOMEWHERE;
        // 1. 通过context获取到相关联的 Channel 的引用
        Channel channel = ctx.channel();
        // 2. 透过 Channel 写入缓冲区
        channel.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
    }

    /**
     * 代码清单6-7 通过ChannelHandlerContext 访问 ChannelPipeline
     */
    public static void writeViaChannelPipeline() {
        ChannelHandlerContext ctx = CHANNEL_HANDLER_CONTEXT_FROM_SOMEWHERE;
        // 1. 通过context获取到 相关联的 ChannelPipeline的引用
        ChannelPipeline pipeline = ctx.pipeline();
        // 2. 通过 ChannelPipeline 写入缓冲区
        pipeline.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
    }




}
