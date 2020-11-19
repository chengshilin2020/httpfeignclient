package com.example.feign;

import com.example.feign.entity.User;
import net.sf.json.JSONObject;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OkHttpClientTest {
    private OkHttpClient client = new OkHttpClient();
    @Test
    public void testGet() throws IOException {
        String url = "http://localhost:8080/producerHello?name=123";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }
    @Test
    public void testPost() throws IOException {
        String url = "http://localhost:8080/deja";
        //请求参数
        User user =new User();
        user.setAge(121);
        user.setName("xiaomi");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),String.valueOf(JSONObject.fromObject(user)));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody) //post请求
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }
}
