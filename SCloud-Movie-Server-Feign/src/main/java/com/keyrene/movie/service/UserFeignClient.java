package com.keyrene.movie.service;

import com.keyrene.movie.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: KeyreneLu
 * Date: 2018-06-17
 * Time: 14:06
 */
@FeignClient(value = "SCLOUD-USER-SERVER")
public interface UserFeignClient {

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id);
}
