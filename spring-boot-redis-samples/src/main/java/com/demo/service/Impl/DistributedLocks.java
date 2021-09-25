package com.demo.service.Impl;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author : zhang pan
 * @date : 10:14 下午 2021/9/20
 * 描述：分布式锁的实现
 */
@Service
public class DistributedLocks {

    private int count = 0;
    private String lockKey = "lock";
    private static final String LOCK_SUCCESS = "OK";
    private static final long UNLOCK_SUCCESS = 1L;

    /**
     * 加锁
     * @param jedis
     * @param lockKey
     * @param value
     * @param expireTime
     * @return
     */
    public static boolean trylock(Jedis jedis,String lockKey,
                                  String value,int expireTime){
        //自旋锁
        while(true){
            String result = jedis.set(lockKey, value, SetParams.setParams().ex(expireTime).nx());
            if(LOCK_SUCCESS.equals(result)){
                return true;
            }
        }
    }

    /**
     * 解锁
     * @param jedis
     * @param lockKey
     * @return
     */
    public static boolean unlock(Jedis jedis,String lockKey){
        Long result = jedis.del(lockKey);
        if(UNLOCK_SUCCESS == result){
            return true;
        }
        return false;
    }

    public void call (Jedis jedis){
        boolean locked = trylock(jedis, lockKey, UUID.randomUUID().toString(), 60);
        try {
            if(locked){
                for(int i = 0;i < 500;i++){
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            unlock(jedis,lockKey);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JedisPool pool = new JedisPool("localhost", 6379, null, "123456");
        DistributedLocks distributedLocks = new DistributedLocks();
        Thread t1 = new Thread(() -> distributedLocks.call(pool.getResource()));
        Thread t2 = new Thread(() -> distributedLocks.call(pool.getResource()));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(distributedLocks.count);
    }
}
