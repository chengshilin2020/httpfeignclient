package com.example.feign.service;

import com.example.feign.entity.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

public interface RemoteService {
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("POST /deja")
    User getOwner(User user);

    @RequestLine("GET /producerHello?name={name}")
    String sayHello(@Param(value = "name") String name);

}
