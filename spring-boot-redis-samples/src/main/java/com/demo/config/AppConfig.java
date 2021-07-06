package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * @author : zhang pan
 * @date : 10:27 上午 2021/6/10
 * 描述：
 */
@Configuration
public class AppConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("127.0.0.1", 6379);
        redisStandaloneConfiguration.setPassword("123456");
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

}