package NettyinAction.chp11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * 代码清单11-5 使用HTTPS
 */
public class HttpsCodecInitializer extends ChannelInitializer<Channel> {
    private final SslContext context;
    private final boolean isClient;

    public HttpsCodecInitializer(SslContext context, boolean isClient) {
        this.context = context;
        this.isClient = isClient;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        SSLEngine engine = context.newEngine(channel.alloc());
        // 1. 将SslHandler 添加到ChannelPipeline 中以使用HTTPS
        pipeline.addFirst("ssl", new SslHandler(engine));
        if(isClient) {
            // 2. 如果是客户端，则添加HttpClientCodec
            pipeline.addLast("codec", new HttpClientCodec());
        } else {
            // 3. 如果是服务器，则添加HttpServerCodec
            pipeline.addLast("codec", new HttpServerCodec());
        }
    }
}
