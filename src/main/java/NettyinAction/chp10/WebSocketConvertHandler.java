package NettyinAction.chp10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.websocketx.*;

import java.util.List;

/**
 * MessageToMessageCodec<INBOUND_IN, OUTBOUND_IN>
 */
public class WebSocketConvertHandler extends MessageToMessageCodec<WebSocketFrame, MyWebSocketFrame> {

    /**
     * encode（）方法处理出站数据，会将OUTBOUND_IN 类型数据，编码为，INBOUND_IN类型数据。
     * 即将 MyWebSocketFrame类型，编码为 WebSocketFrame类型。
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, MyWebSocketFrame msg, List<Object> list) throws Exception {

        ByteBuf payload = msg.getData().duplicate().retain();
        // 实例化一个子类型的 WebSocketFrame
        switch (msg.getType()) {
            case BINARY:
                list.add(new BinaryWebSocketFrame(payload));
                break;
            case TEXT:
                list.add(new TextWebSocketFrame(payload));
                break;
            case CLOSE:
                list.add(new CloseWebSocketFrame(true, 0, payload));
                break;
            case CONTINUATION:
                list.add(new ContinuationWebSocketFrame(payload));
                break;
            case PONG:
                list.add(new PongWebSocketFrame(payload));
                break;
            case PING:
                list.add(new PingWebSocketFrame(payload));
                break;
            default:
                throw new IllegalStateException("Unsupported websocket msg " + msg);

        }
    }

    /**
     * decode()方法处理入站数据，会将 INBOUND_IN 类型数据，解码为，OUTBOUND_IN 类型数据。
     * 即将 WebSocketFrame 类型数据解码为， MyWebSocketFrame 类型数据。
     * 并设置 FrameType
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, WebSocketFrame msg, List<Object> list) throws Exception {
        ByteBuf payload = msg.content().duplicate().retain();
        if (msg instanceof BinaryWebSocketFrame) {
            list.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.BINARY, payload));
        } else {
            if (msg instanceof CloseWebSocketFrame) {
                list.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.CLOSE, payload));
            }else
                if (msg instanceof PingWebSocketFrame) {
                    list.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.PING, payload));
                } else
                    if (msg instanceof PongWebSocketFrame) {
                        list.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.PONG, payload));
                    } else
                        if (msg instanceof TextWebSocketFrame) {
                            list.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.TEXT, payload));
                        }else
                            if (msg instanceof ContinuationWebSocketFrame) {
                                list.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.CONTINUATION, payload));
                            }else {
                                throw new IllegalStateException("Unsupported websocket msg " + msg);
                            }
        }
    }
}
