package com.example.feign.controller;

import com.example.feign.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @PostMapping("deja")
    @ResponseBody
    public User helllo(@RequestBody User user){
        System.out.println(user.getName());
        user.setAge(3333);
        user.setName(user.getName().toUpperCase());
        return user;
    }
    @GetMapping("/producerHello")
    public String Hello(String name){
        return "hello " + name + "，this is demo-client1 messge";
    }
}
