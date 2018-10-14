package org.java.service;

import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName UserService
 * @Description 用户登录
 * @Author Administrator
 * @Date 2018/10/14 0014 9:10
 * @Version 1.0
 **/
public interface UserService {
    public Map<String,Object> checkLogin(Map<String,Object> user);
}
