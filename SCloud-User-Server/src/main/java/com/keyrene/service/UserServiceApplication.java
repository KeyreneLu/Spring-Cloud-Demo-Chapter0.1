package com.keyrene.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

    public static void main(String[] args){
        SpringApplication.run(UserServiceApplication.class,args);
        System.out.println("【【【【【【 用户微服务 】】】】】】已启动.");
    }

}
