package com.example.feign;

import com.example.feign.entity.User;
import com.example.feign.service.RemoteService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FeignApplicationTests {
    RemoteService service = Feign.builder()
//            .encoder(new JacksonEncoder())
//            .decoder(new JacksonDecoder())
            .options(new Request.Options(1000, 3500))
            .retryer(new Retryer.Default(5000, 5000, 3))
            .target(RemoteService.class, "http://localhost:8080");
    @Test
    void contextLoads() {

        User u = new User();
        u.setAge(1233);
        u.setName("yaohuiqin");
        User result = service.getOwner(u);
        System.out.println(result.getName());
    }
    @Test
    void conget(){
        String result = service.sayHello("scott");
        System.out.println(result);
    }

}
