package NettyinAction.chp11;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.stream.ChunkedStream;

import java.io.File;
import java.io.FileInputStream;

/**
 * 代码清单11-12-2
 */
public class WriteStreamHandler extends ChannelInboundHandlerAdapter {
    private File file = new File(" ");

    /**
     * 当Channel的状态变为活动的时候，WriteStreamHandler 将会逐块地把来自文件中的
     * 数据作为 ChunkedStream写入。数据在传输之前会由 SslHandler加密。
     */

    // 当连接建立时，channelActive()方法将使用ChunkedInput 写文件数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.writeAndFlush(new ChunkedStream(new FileInputStream(file)));
    }
}
