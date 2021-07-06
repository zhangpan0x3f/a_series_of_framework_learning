package com.demo.service.Impl;

import com.demo.service.TestService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : zhang pan
 * @date : 11:09 上午 2021/6/10
 * 描述：
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void setValue(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public String getValue(String key){
        String value = (String)redisTemplate.opsForValue().get(key);
        return value;
    }

}
