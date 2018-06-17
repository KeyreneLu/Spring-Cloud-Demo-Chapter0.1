package com.keyrene.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: KeyreneLu
 * Date: 2018-06-17
 * Time: 15:19
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.keyrene.movie")
@ComponentScan("com.keyrene.movie")
public class FeignServerApplication {

    public static void main(String[] args){
        SpringApplication.run(FeignServerApplication.class,args);
    }
}
