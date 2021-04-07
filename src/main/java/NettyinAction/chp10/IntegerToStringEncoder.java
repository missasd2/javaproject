package NettyinAction.chp10;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 代码清单10-6 将消息从一种格式转换为另一种 */
public class IntegerToStringEncoder extends MessageToMessageEncoder<Integer> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Integer msg, List<Object> list) throws Exception {
        list.add(String.valueOf(msg)); // 将Integer 转化为String，并将其添加到List中
    }
}
