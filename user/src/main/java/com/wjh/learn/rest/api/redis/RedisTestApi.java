package com.wjh.learn.rest.api.redis;

import com.wjh.learn.common.ResData;
import com.wjh.learn.config.SpringBeanUtil;
import com.wjh.learn.user.util.RedisHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/redis/test")
public class
RedisTestApi {

    @GetMapping("/set")
    public ResData set(@RequestParam(name = "key") String key, @RequestParam(name = "value") String value) throws IOException {
        ResData resData = ResData.SUCCESS();
        RedisHelper redisHelper = SpringBeanUtil.getBean(RedisHelper.class);
        Jedis jedis = redisHelper.getJedis();
        jedis.set(key, value);
        String luaScript = readLuaScript();
        List<String> helloLua = Arrays.asList(value, "hello lua");
        Object eval = jedis.eval(luaScript, Collections.singletonList(key), helloLua);
        resData.setData(eval);

        return resData;
    }


    private String readLuaScript() throws IOException {
        ResourceScriptSource resourceScriptSource = new ResourceScriptSource(new ClassPathResource("redis/test.lua"));
        String scriptAsString = resourceScriptSource.getScriptAsString();
        System.out.println(scriptAsString);
        return scriptAsString;
    }
}
