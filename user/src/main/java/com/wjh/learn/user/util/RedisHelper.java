package com.wjh.learn.user.util;

import com.wjh.learn.user.config.RedisProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis工具类
 */
public class RedisHelper {

    private JedisPool jedisPool;
    private RedisProperties redisProperties;

    public RedisHelper(JedisPool jedisPool, RedisProperties redisProperties) {
        this.jedisPool = jedisPool;
        this.redisProperties = redisProperties;
    }

    public JedisPool getJedisPool() {
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
        if (jedisPool != null) {
            Jedis jedis = jedisPool.getResource();
            jedis.auth(redisProperties.getPassword());
            jedis.select(index);

            return jedis;
        }

        return null;
    }
}
