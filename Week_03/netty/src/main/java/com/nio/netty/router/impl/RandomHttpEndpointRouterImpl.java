package com.nio.netty.router.impl;

import com.nio.netty.router.HttpEndpointRouter;

import java.util.List;
import java.util.Random;

/**
 * @author netty -- chengyan
 * @date 2021/1/21 23:23
 **/
public class RandomHttpEndpointRouterImpl implements HttpEndpointRouter {


    @Override
    public String route(List<String> urls) {

        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
