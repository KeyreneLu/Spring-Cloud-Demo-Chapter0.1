package com.keyrene.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: KeyreneLu
 * Date: 2018-06-17
 * Time: 16:48
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulServerApplication {

    public static void main(String[] args){
        SpringApplication.run(ZuulServerApplication.class,args);
    }
}
