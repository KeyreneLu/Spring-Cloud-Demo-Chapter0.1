package com.keyrene.service.controller;

import com.keyrene.service.bean.User;
import com.keyrene.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/find/{id}")
    public User getUser(@PathVariable Long id){
        return userRepository.findOne(id);
    }
}
