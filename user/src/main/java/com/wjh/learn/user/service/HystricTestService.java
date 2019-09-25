package com.wjh.learn.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wjh.learn.common.ResData;
import org.springframework.stereotype.Service;

/**
 * Hystric test
 * @author wjh
 * @date 2019/9/25 21:38
 */
@Service
public class HystricTestService {

    @HystrixCommand(fallbackMethod = "defaultSay")
    public ResData say(String string) {
        ResData resData = ResData.SUCCESS(string);
        System.out.println(1/0);
        return resData;
    }
    
    public ResData defaultSay(String string) {
        ResData resData = ResData.fail(4002, "hystric test");
        return resData;
    }
}
