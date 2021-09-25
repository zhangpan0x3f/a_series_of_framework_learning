package com.demo.service.Impl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author : zhang pan
 * @date : 10:18 上午 2021/9/21
 * 描述：过期的实现
 */
public class Expire {


    public static void expire(Jedis jedis,String key){
        if(!jedis.exists(key)){
            System.out.println("key不存在");
        }
        jedis.expire(key,60L);
        System.out.println("已经设置过期时间");
    }

    public static void main(String[] args) {
        JedisPool pool = new JedisPool("localhost", 6379, null, "123456");
        Jedis resource = pool.getResource();
        expire(resource,"name");
    }

}
