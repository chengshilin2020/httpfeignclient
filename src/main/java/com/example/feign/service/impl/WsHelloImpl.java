package com.example.feign.service.impl;

import com.example.feign.service.WsHello;

import javax.jws.WebService;

@WebService
public class WsHelloImpl implements WsHello {

    public String sayHello(String name) {
        System.out.println(" server sayHello()" + name);
        return "hello world" + name;
    }
}
