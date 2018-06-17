package com.keyrene.movie.controller;

import com.keyrene.movie.bean.User;
import com.keyrene.movie.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: KeyreneLu
 * Date: 2018-06-17
 * Time: 15:22
 */
@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/movie/{id}",method = RequestMethod.GET)
    public User getUserBy(@PathVariable("id") Long id){
        return this.userFeignClient.getUser(id);
    }
}
