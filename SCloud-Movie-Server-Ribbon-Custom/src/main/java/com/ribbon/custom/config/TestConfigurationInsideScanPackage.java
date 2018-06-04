package com.ribbon.custom.config;

import com.netflix.loadbalancer.IRule;
import com.ribbon.custom.ExcludeFromComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class TestConfigurationInsideScanPackage {

    @Bean
    public IRule ribbonRule(){
        return new Rule_Custom();
    }
}
