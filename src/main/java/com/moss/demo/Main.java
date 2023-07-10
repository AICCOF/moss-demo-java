package com.moss.demo;

import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;

/**
 * demo入口
 *
 * @author wangsen
 * @since 2023/7/10 18:58
 */
public class Main {

    // TODO 替换成自己的API_KEY
    private static final String API_KEY = "moss-jp5vpvrrcgliju1a10q078isme5rhed834rp6hc9q3dvak2e";


    public static void main(String[] args) throws Exception {
        JSONObject params = new JSONObject();
        params.put("model", "gpt-3.5-turbo-16k-0613");
        params.put("prompt", "Human:你好\nAI:你好！很高兴和你交谈，有什么可以帮助你的吗？\nHuman:你是谁？");

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, params.toJSONString());
        Request request = new Request.Builder()
                .url("http://api.aihao123.cn/moss/v1/completions")
                .post(body)
                .addHeader("Authorization", API_KEY)
                .addHeader("content-type", "application/json")
                .build();

        Response response = client.newCall(request).execute();

        // 打印响应体
        System.out.println(response.body().string());
    }
}