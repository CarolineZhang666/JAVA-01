package com.nio.netty.inbound;

import com.nio.netty.filter.impl.HeaderHttpRequestFilterImpl;
import com.nio.netty.filter.HttpRequestFilter;
import com.nio.netty.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

import io.netty.util.ReferenceCountUtil;

import java.util.List;

/**
 * @author netty -- chengyan
 * @date 2021/1/21 23:26
 **/
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private final List<String> proxyServer;
    private HttpOutboundHandler handler;
    private HttpRequestFilter filter = new HeaderHttpRequestFilterImpl();

    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpOutboundHandler(this.proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {

            FullHttpRequest fullRequest = (FullHttpRequest) msg;

            handler.handle(fullRequest, ctx, filter);

        } catch(Exception e) {

            e.printStackTrace();

        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
