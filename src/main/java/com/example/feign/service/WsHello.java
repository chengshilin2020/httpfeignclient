package com.example.feign.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WsHello {
    @WebMethod
    public String sayHello(String name);
}
