package com.wjh.learn.websocket.api;

import com.wjh.learn.common.ResData;
import com.wjh.learn.domain.user.User;
import com.wjh.learn.websocket.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2019/9/9 22:05
 */
@RestController
@RequestMapping("/api/websocket")
public class FeignController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/update")
    public ResData update(User user) {
        return userClient.update(user);
    }
}
