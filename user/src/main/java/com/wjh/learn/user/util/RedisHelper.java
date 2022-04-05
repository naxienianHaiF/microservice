package com.wjh.learn.user.util;

import com.wjh.learn.config.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis工具类
 */
@Component
@ConditionalOnClass(name = "com.wjh.learn.config.RedisProperties")
public class RedisHelper {

    private JedisPool jedisPool;
    @Autowired
    private RedisProperties redisProperties;

    public JedisPool getJedisPool() {
        if (jedisPool == null) {
            jedisPool = new JedisPool(redisProperties.getHost(), redisProperties.getPort());
        }
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 使用redis配置文件中的database
     */
    public Jedis getJedis() {
        return getJedisWithDb(redisProperties.getDatabase());
    }

    /**
     *
     * @param index 数据库
     */
    public Jedis getJedisWithDb(int index) {
        if (getJedisPool() != null) {
            Jedis jedis = jedisPool.getResource();
            jedis.auth(redisProperties.getPassword());
            jedis.select(index);

            return jedis;
        }

        return null;
    }
}
