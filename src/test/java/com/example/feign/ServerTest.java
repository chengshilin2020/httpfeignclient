package com.example.feign;

import com.example.feign.service.impl.WsHelloImpl;
import com.example.feign.service.impl.WsHelloImplService;
import org.junit.jupiter.api.Test;

import javax.xml.ws.Endpoint;
public class ServerTest {
    public static void main(String[] args) {
        String address = "http://localhost/wshello";
        Endpoint.publish(address, new WsHelloImpl());
        System.out.println("发布成功");
    }
    @Test
    void diaoyong(){
        WsHelloImplService factory = new WsHelloImplService();
        com.example.feign.service.WsHelloImpl hello = factory.getWsHelloImplPort();
        String result = hello.sayHello("Jack");
        System.out.println("client:" + result);
    }
}
