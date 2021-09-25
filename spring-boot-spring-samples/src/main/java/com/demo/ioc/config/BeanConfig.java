package com.demo.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.client.RestTemplate;

/**
 * @author : zhang pan
 * @date : 10:57 上午 2021/7/13
 * 描述：
 */
@Configuration
public class BeanConfig {

    //定义别名
    @AliasFor()
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
