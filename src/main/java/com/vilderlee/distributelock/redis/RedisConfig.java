package com.vilderlee.distributelock.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 功能描述:
 *
 * @package com.vilderlee.distributelock.redis
 * @auther vilderlee
 * @date 2019-07-25 22:19
 */

@Configuration
@PropertySource("redis.properties")
@ComponentScan("com.vilderlee.distributelock.redis")
public class RedisConfig {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;

    @Value("${redis.password}")
    private String password;


    @Bean
    public Jedis jedis() {
        JedisPool poolConfig = new JedisPool(new JedisPoolConfig(), host, Integer.valueOf(port), 3000, password);
        return poolConfig.getResource();
    }
}
