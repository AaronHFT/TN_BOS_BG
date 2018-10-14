package org.java.service.impl;

import org.java.dao.UserMapper;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/10/14 0014 9:11
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> checkLogin(Map<String, Object> user) {
        return userMapper.checkLogin(user);
    }
}
