package com.wjh.learn.user.service;

import com.wjh.learn.common.ResData;
import com.wjh.learn.domain.user.User;
import com.wjh.learn.user.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户类
 * @author wjh
 * @date 2019/8/28 21:24
 */
@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, timeout = 5000, rollbackFor = Exception.class)
    public ResData register(User user) {
        ResData resData = null;

        if (user == null || StringUtils.isEmpty(user.getUsername())) {
            resData = ResData.fail(1001, "用户信息不能为空");
            return resData;
        }

        User oneUser = userMapper.selectOneUser(user);
        if (oneUser != null ){
            resData = ResData.fail(1002, "用户名或者手机号码已经被注册了");
            return resData;
        }

        int save = userMapper.save(user);

        resData = ResData.SUCCESS("注册成功");
        return resData;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, timeout = 5000, rollbackFor = Exception.class)
    public ResData update(User user) {
        ResData resData = ResData.SUCCESS("更新成功");

        int update = userMapper.update(user);

        resData.setData(update);
        return resData;
    }

    @Transactional(propagation = Propagation.REQUIRED, timeout = 5000, rollbackFor = Exception.class)
    public ResData find(User user) {
        ResData resData = ResData.SUCCESS();

        List<User> users = userMapper.selectManyUser(user);
        resData.setData(users);
        return resData;
    }
}
