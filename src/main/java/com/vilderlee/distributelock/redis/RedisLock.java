package com.vilderlee.distributelock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @package com.vilderlee.distributelock.redis
 * @auther vilderlee
 * @date 2019-07-25 22:31
 */

@Component
public class RedisLock {

    @Autowired
    private Jedis jedis;

    public boolean tryLock(long productID) {
        int random = new Random().nextInt();
        String value = String.valueOf(random);

        String result = jedis.set("productID" + productID, value, "NX", "PX", 30000L);

        System.out.println(result);
        if ("OK".equals(result)) {
            return true;
        }

        return false;
    }


    public String get(long productID) {
        return jedis.get("productID" + productID);

    }

    public void lock(long productID) {
        //如果锁失败
        while (!tryLock(productID)) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void unLock(long productID) {
        String script = "if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1] ) else return 0 end";
        jedis.eval(script,1, "productID" + productID, get(productID));
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);

        RedisLock redisLock = context.getBean(RedisLock.class);

        redisLock.lock(1L);

        System.out.println(redisLock.get(1L));

        redisLock.unLock(1L);


        System.out.println(redisLock.get(1L));


    }
}
