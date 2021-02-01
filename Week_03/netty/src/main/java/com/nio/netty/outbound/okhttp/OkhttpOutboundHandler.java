package com.nio.netty.outbound.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author netty -- chengyan
 * @date 2021/1/21 23:27
 **/
public class OkhttpOutboundHandler {

    public static String getSyncRequest(String url) {

        String responseResult = "";

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {

            responseResult = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseResult;
    }

    public static void main(String[] args) {

        String url = "http://127.0.0.1:8801";

        String text = OkhttpOutboundHandler.getSyncRequest(url);

        System.out.println("url: " + url + "\nresponse: " + text);

    }
}
