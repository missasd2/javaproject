package NettyinAction.chp11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 代码清单11-7 发送心跳；
 * 60秒间隔
 */
public class IdleStateHandlerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        // 1. IdleStateHandler 将在被触发时发送一个IdleStateEvent事件
        pipeline.addLast(
                new IdleStateHandler(0, 0, 60, TimeUnit.SECONDS)
        );
        // 2. 将一个HeartbeatHandler 添加到ChannelPipeline中
        pipeline.addLast(new HeartbeatHandler());
    }
}
