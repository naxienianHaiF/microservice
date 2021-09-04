package com.wjh.learn.rest.api;

import com.wjh.learn.common.ResData;
import com.wjh.learn.domain.user.User;
import com.wjh.learn.user.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author wjh
 * @date 2019/8/28 20:56
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
    private UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ResData register(User user) {
        return userService.register(user);
    }

    @GetMapping("/update")
    public ResData update(User user) {
        return userService.update(user);
    }

    @GetMapping("/find")
    public ResData find(User user) {
        return userService.find(user);
    }
}
