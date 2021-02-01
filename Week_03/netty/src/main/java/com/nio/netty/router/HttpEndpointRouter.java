package com.nio.netty.router;

import java.util.List;

/**
 * @author netty -- chengyan
 * @date 2021/1/22 14:40
 **/
public interface HttpEndpointRouter {

    String route(List<String> urls);

    // Load Balance
    // Random
    // RoundRibbon
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50
}
