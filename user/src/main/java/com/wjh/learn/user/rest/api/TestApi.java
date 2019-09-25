package com.wjh.learn.user.rest.api;

import com.wjh.learn.common.ResData;
import com.wjh.learn.user.service.HystricTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2019/9/25 21:54
 */
@RestController
public class TestApi {

    @Autowired
    private HystricTestService testService;

    @GetMapping("/test")
    public ResData test(String msg) {
        return testService.say(msg);
    }
}
