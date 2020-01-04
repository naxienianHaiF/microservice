package com.wjh.learn.user.rest.api;

import com.wjh.learn.common.ResData;
import com.wjh.learn.user.service.HystricTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2019/9/25 21:54
 */
@RestController
@Api(tags = "test接口")
public class TestApi {

    @Autowired
    private HystricTestService testService;

    @GetMapping("/test")
    @ApiOperation(value = "132", tags = "API test", notes = "测试ApiOperation")
    @ApiImplicitParam(name = "msg", value = "输入信息", dataType = "String")
    public ResData test(String msg) {
        return testService.say(msg);
    }
}
