package com.demo.service.Impl;

import com.demo.service.JedisService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;

/**
 * @author : zhang pan
 * @date : 8:37 下午 2021/9/20
 * 描述：
 */
@Service
public class JedisServiceImpl implements JedisService {

    private static int count = 1;

    @Resource
    private JedisPool jedisPool;

    @Override
    public void get(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("middleware", "dubbo");
        String middleware = jedis.get("middleware");
        jedis.expire("middleware",10);
        System.out.println(middleware);
    }

    public void distributedLocks(){
        try(Jedis pool = jedisPool.getResource()){
            SetParams setParams = new SetParams();
            setParams.nx();
            setParams.px(30000);
            pool.set("count",count + "",setParams);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
