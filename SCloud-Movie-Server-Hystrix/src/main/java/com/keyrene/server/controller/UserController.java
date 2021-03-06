package com.keyrene.server.controller;

import com.keyrene.server.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;


    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    public User getUser(@PathVariable Long id){

        return this.restTemplate.getForObject(this.userServicePath+"/find/"+id,User.class);
    }

    public User findByIdFallBack(Long id){
        User user = new User();
        user.setId(0L);
        return user;
    }
}
