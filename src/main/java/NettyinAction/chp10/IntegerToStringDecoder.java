package NettyinAction.chp10;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class IntegerToStringDecoder extends MessageToMessageEncoder<Integer> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Integer integer, List<Object> list) throws Exception {
        // 将Integer 消息转换为它的 String 表示，并将其添加到输出的List 中
        list.add(String.valueOf(integer));
    }
}
