package com.keyrene.ribbon.controller;

import com.keyrene.ribbon.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User getUser(@PathVariable Long id){
        return this.restTemplate.getForObject("http://scloud-user-server/find/"+id,User.class);
    }
}
