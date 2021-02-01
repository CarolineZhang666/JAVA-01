package com.nio.netty.filter.impl;

import com.nio.netty.filter.HttpResponseFilter;
import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author netty -- chengyan
 * @date 2021/1/21 23:25
 **/
public class HeaderHttpResponseFilterImpl implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {

        response.headers().set("doudou", "java-1-nio");
    }
}
