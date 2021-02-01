package com.nio.netty.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author netty -- chengyan
 * @date 2021/1/22 14:47
 **/
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);
}
