package NettyinAction.chp10;

import io.netty.channel.CombinedChannelDuplexHandler;

/**
 * 代码清单 10-10
 * public class CombinedChannelDuplexHandler<I extends ChannelInboundHandler, O extends ChannelOutboundHandler>
 */
public class CombinedByteCharCodec extends CombinedChannelDuplexHandler<ByteToCharDecoder, CharToByteEncoder> {

    public CombinedByteCharCodec() {
        super(new ByteToCharDecoder(), new CharToByteEncoder()); // 将委托实例 传递给父类
    }
}
