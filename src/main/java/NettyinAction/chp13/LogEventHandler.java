package NettyinAction.chp13;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 代码清单13-7 LogEventHandler 在 13-6 的 LogEventDecoder这一Handler后，
 * 继续对所创建的LogEvent 进行后续处理。
 */
public class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {

    // 当异常发生时，打印栈跟踪信息，并关闭对应的Channel
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogEvent logEvent) throws Exception {
        StringBuilder builder = new StringBuilder(); // 创建StringBuilder，并且构建输出的字符串
        builder.append(logEvent.getReceivedTimestamp());
        builder.append(" [");
        builder.append(logEvent.getSource().toString());
        builder.append("] [");
        builder.append(logEvent.getLogfile());
        builder.append("] : ");
        builder.append(logEvent.getMsg());
        // 打印 LogEvent 的数据
        System.out.println(builder.toString());
    }
}
