package NettyinAction.chp6;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelPipeline;

public class ModifyChannelPipeline {
    private static final ChannelPipeline CHANNEL_PIPELINE_FROM_SOMEWHERE = DummyChannelPipeline.DUMMY_INSTANCE;

    /**
     * 代码清单6-5 修改ChannelPipeline
     */
    public static void modifyPipeline() {
        ChannelPipeline pipeline = CHANNEL_PIPELINE_FROM_SOMEWHERE;
        // 1. 创建一个FirstHandler 的实例
        FirstHandler firstHandler = new FirstHandler();
        // 2. 将该实例作为“handler1” 添加到 ChannelPipeline 中
        pipeline.addLast("handler1", firstHandler);
        // 3. 将一个SecondHandler的实例作为“handler2”添加到 ChannelPipeline的第一个槽中。这意味着它将被放置在已有的“handler1”之前
        pipeline.addFirst("handler2", new SecondHandler());
        // 4. 将一个ThirdHandler的实例作为“handler3”添加到 ChannelPipeline 的最后一个槽中
        pipeline.addLast("handler3", new ThirdHandler());

        // 5. 通过名称移除 “handler3” 代表的 ChannelHandler的实例
        pipeline.remove("handler3");
        // 通过引用移除FirstHandler， （由于其为唯一的，因此不需要它的名称）
        pipeline.remove(firstHandler);

        // 6. 替换pipeline中的ChannelHandler
        // 将一个名称为“handler2”的ChannelHandler实例，替换为一个名为“handler4”的ChannelHandler实例
        pipeline.replace("handler2", "handler4", new FourthHandler());

    }

    private static final class FirstHandler extends ChannelHandlerAdapter{}
    private static final class SecondHandler extends ChannelHandlerAdapter{}
    private static final class ThirdHandler extends ChannelHandlerAdapter{}
    private static final class FourthHandler extends ChannelHandlerAdapter{}
}
