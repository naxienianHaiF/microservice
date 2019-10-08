package com.wjh.learn.websocket.client;

import com.wjh.learn.common.ResData;
import com.wjh.learn.domain.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wjh
 * @date 2019/9/9 22:02
 */
@FeignClient(name = "user", path = "/user/api")
public interface UserClient {

    @GetMapping("/user/update")
    ResData update(@SpringQueryMap User user);
}
