package com.vilderlee.distributelock.redisson;


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @package com.vilderlee.distributelock
 * @auther vilderlee
 * @date 2019-07-25 23:19
 */
public class RedissonLock {

    public static void main(String[] args) {
        Config config = new Config();

        config.useSingleServer().setAddress("redis://39.104.159.18:6379").setPassword("lichao.5220246");
        Redisson redisson = (Redisson) Redisson.create(config);

        RLock lock = redisson.getLock("product1");

        lock.lock(30, TimeUnit.SECONDS);

    }

}
