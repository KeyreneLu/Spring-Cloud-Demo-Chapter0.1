package com.ribbon.custom.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfigurationOutsideScanPackage {

    /**
     * 负载均衡调度算法：轮循RoundRobinRule策略算法
     * @return IRule 策略算法
     */
    @Bean
    public IRule ribbonRule(){
        return new RoundRobinRule();
    }
}
