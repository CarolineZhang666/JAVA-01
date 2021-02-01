package com.nio.netty.filter.impl;

import com.nio.netty.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author netty -- chengyan
 * @date 2021/1/21 23:25
 **/
public class HeaderHttpRequestFilterImpl implements HttpRequestFilter {


    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {

        fullRequest.headers().set("hongg", "dou");
    }
}
