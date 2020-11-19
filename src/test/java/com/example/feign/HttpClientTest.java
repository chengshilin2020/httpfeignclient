package com.example.feign;

import com.example.feign.entity.User;
import net.sf.json.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;


public class HttpClientTest {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    @Test
    public void testGet() throws IOException {
        String url = "http://localhost:8080/producerHello?name=123";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
    @Test
    public void testPost() throws IOException {
        String url = "http://localhost:8080/deja";
        HttpPost httpPost = new HttpPost(url);
        User user =new User();
        user.setAge(121);
        user.setName("xiaomi");
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setEntity(new StringEntity(String.valueOf(JSONObject.fromObject(user)), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
