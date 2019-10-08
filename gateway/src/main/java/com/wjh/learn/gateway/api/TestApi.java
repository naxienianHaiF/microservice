package com.wjh.learn.gateway.api;

import com.wjh.learn.common.ResData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2019/9/22 9:52
 */
@RestController
public class TestApi {

    @GetMapping("/test")
    public ResData test() {
        return ResData.SUCCESS("test");
    }
}
