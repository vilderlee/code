package com.vilderlee.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/22      Create this file
 * </pre>
 */
public class RedisTest {
    public static void main(String[] args) {

        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379, 1000, "lichao.5220246");
        Jedis jedis = jedisPool.getResource();
        long start = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 1000000; i++) {
            pipeline.set("Key" + i, "Value" + i);
        }

        pipeline.sync();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
